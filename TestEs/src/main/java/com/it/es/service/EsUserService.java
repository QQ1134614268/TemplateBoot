package com.it.es.service;

import com.it.es.config.IndexConf;
import com.it.es.dao.EsUserRepository;
import com.it.es.entity.EsUser;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHitsImpl;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EsUserService {
    // 组合查询BoolQueryBuilder
    // builder下有must、should以及mustNot 相当于sql中的and、or以及not
    // range term terms exists fuzzy match matchAll

    @Resource
    EsUserRepository esUserRepository;

    // @Resource
    // private ElasticsearchOperations elasticsearchOperations;
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public void update(String search) {
        Document document = Document.create();
        document.putIfAbsent("name", "name2");
        String id = "1";
        document.setId(id);
        UpdateQuery build = UpdateQuery.builder(id).withDocument(document).withScriptedUpsert(true).build();
        elasticsearchRestTemplate.update(build, IndexCoordinates.of(IndexConf.ES_USER_INDEX));
    }

    public PageImpl<EsUser> page(Pageable pageable, String search) {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.must(QueryBuilders.fuzzyQuery("name", search))
                .should(QueryBuilders.fuzzyQuery("desc", search));

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withSorts(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                .withQuery(builder);

        SearchHits<EsUser> res = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), EsUser.class);
        List<EsUser> list = res.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
        return new PageImpl<>(list, pageable, res.getTotalHits());
    }


    public Map<String, Object> scroll(String scrollId, Integer pageSize) {
        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(0, pageSize));
        SearchHits<EsUser> res;
        int scrollTimeInMillis = 60 * 1000;
        if (StringUtils.hasLength(scrollId) || scrollId.equals("0")) {
            // 开启一个滚动查询,设置该scroll上下文存在60s
            // 同一个scroll上下文,只需要设置一次query(查询条件)
            res = elasticsearchRestTemplate.searchScrollStart(scrollTimeInMillis, query, EsUser.class, IndexCoordinates.of(IndexConf.ES_USER_INDEX));
            if (res instanceof SearchHitsImpl) {
                scrollId = ((SearchHitsImpl<?>) res).getScrollId();
            }
        } else {
            // 继续滚动
            res = elasticsearchRestTemplate.searchScrollContinue(scrollId, scrollTimeInMillis, EsUser.class, IndexCoordinates.of(IndexConf.ES_USER_INDEX));
        }
        List<EsUser> list = res.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());

        if (list.isEmpty()) {
            // 结束滚动
            elasticsearchRestTemplate.searchScrollClear(Collections.singletonList(scrollId));
            scrollId = null;
        }
        Map<String, Object> result;
        if (Objects.isNull(scrollId)) {
            result = new HashMap<>(2);
            result.put("EsUser", list);
            result.put("message", "已到末尾");
        } else {
            result = new HashMap<>();
            result.put("count", String.valueOf(res.getTotalHits()));
            result.put("pageSize", String.valueOf(list.size()));
            result.put(IndexConf.ES_USER_INDEX, list);
            result.put("scrollId", scrollId);
        }
        return result;
    }
}
