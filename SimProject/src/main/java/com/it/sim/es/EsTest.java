package com.it.sim.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EsTest {
    public static final String ID_WU_KONG = "p4AtG3kBRz-Sn-2fMFjj";
    public static final String ES_USER_INDEX = "es_user";
    static ObjectMapper mapper = new ObjectMapper();

    private RestHighLevelClient es;

    @Before
    public void getClient() {
        es = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
    }

    /**
     * ???ES????????????es_user??????type???????????????????????????
     */
    @Test
    public void test_1_Add() throws IOException {
        IndexRequest indexRequest = new IndexRequest(ES_USER_INDEX);
        EsUser u = new EsUser(ID_WU_KONG, "?????????????????????", Date.valueOf(LocalDate.of(1685, 1, 1)), "??????????????????????????????????????????????????????", "??????????????????", 180f);
        String json = mapper.writeValueAsString(u);
        indexRequest.source(json, XContentType.JSON);
        IndexResponse indexResponse = es.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.status());
    }

    @Test
    public void test_2_updateDoc() throws IOException {
        String id = getId();
        UpdateRequest updateRequest = new UpdateRequest(ES_USER_INDEX, id);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "???????????????hardy");
        updateRequest.doc(map, XContentType.JSON);
        UpdateResponse updateResponse = es.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());
    }

    @Test
    public void test_3_deleteDoc() throws IOException {
        String id = getId();
        DeleteRequest deleteRequest = new DeleteRequest(ES_USER_INDEX,id);
        DeleteResponse deleteResponse = es.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }
    @Test
    public void test_4_deleteIndex() throws IOException {
        AcknowledgedResponse deleteResponse = es.indices().delete(new DeleteIndexRequest(ES_USER_INDEX), RequestOptions.DEFAULT);
        System.out.println(deleteResponse.isAcknowledged());
    }
    @Test
    public void bulkUpdate() throws IOException {
        // bulk ????????????, ????????????,????????????
        BulkRequest bulkRequest = new BulkRequest();
        // ??????
        IndexRequest indexRequest = new IndexRequest(ES_USER_INDEX);
        EsUser u = new EsUser(ID_WU_KONG, "?????????????????????", Date.valueOf(LocalDate.of(1685, 1, 1)), "????????????????????????????????????????????????", "?????????", 180f);
        String json = mapper.writeValueAsString(u);
        indexRequest.source(json, XContentType.JSON);
        bulkRequest.add(indexRequest);

        // ??????
        DeleteRequest deleteRequest01 = new DeleteRequest(ES_USER_INDEX, "pYAtG3kBRz-Sn-2fMFjj");
        DeleteRequest deleteRequest02 = new DeleteRequest(ES_USER_INDEX, "uhTyGHkBExaVQsl4F9Lj");
        DeleteRequest deleteRequest03 = new DeleteRequest(ES_USER_INDEX, "C8zCGHkB5KgTrUTeLyE_");
        bulkRequest.add(deleteRequest01);
        bulkRequest.add(deleteRequest02);
        bulkRequest.add(deleteRequest03);

        // ??????
        String id = "10";
        UpdateRequest updateRequest = new UpdateRequest(ES_USER_INDEX, id);
        updateRequest.doc("{\"name\":\"?????????????????????\"}", XContentType.JSON);
        bulkRequest.add(updateRequest);

        BulkResponse bulkResponse = es.bulk(bulkRequest, RequestOptions.DEFAULT);
        BulkItemResponse[] items = bulkResponse.getItems();
        for (BulkItemResponse item : items) {
            System.out.println(item.status());
        }
    }

    @Test
    public void testSearch() throws IOException {
        //??????????????????
        SearchRequest searchRequest = new SearchRequest(ES_USER_INDEX);
        //??????????????????
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())//??????????????????
                .from(0)//????????????
                .size(10)//??????????????????
                .postFilter(QueryBuilders.matchAllQuery()) //????????????
                .sort("birthday", SortOrder.DESC);//??????

        //??????????????????
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = es.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println("???????????????????????????: " + searchResponse.getHits().getTotalHits());
        System.out.println("?????????????????????????????????: " + searchResponse.getHits().getMaxScore());
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void testHighLightQuery() throws IOException, ParseException {
        // ??????????????????
        SearchRequest searchRequest = new SearchRequest(ES_USER_INDEX);
        // ??????????????????
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name.keyword", "?????????????????????"))    // ??????????????????
                .from(0)    // ????????????(?????????-1)*size??????
                .size(10)   // ??????????????????
                .sort("birthday", SortOrder.DESC)    // ??????
                .highlighter(
                        new HighlightBuilder()
                                .field("*")
                                .requireFieldMatch(false)
                                .preTags("<span style='color:red;'>")
                                .postTags("</span>")
                );  // ????????????
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = es.search(searchRequest, RequestOptions.DEFAULT);

        SearchHit[] hits = searchResponse.getHits().getHits();
        List<EsUser> userList = new ArrayList<>();
        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();

            EsUser user = new EsUser();
            user.setId(hit.getId());
            user.setHeight(Float.parseFloat(sourceAsMap.get("height").toString()));
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(sourceAsMap.get("birthday").toString()));
            user.setDesc(sourceAsMap.get("desc").toString());
            user.setName(sourceAsMap.get("name").toString());
            user.setAddress(sourceAsMap.get("address").toString());

            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (highlightFields.containsKey("name")) {
                user.setName(highlightFields.get("name").fragments()[0].toString());
            }

            if (highlightFields.containsKey("desc")) {
                user.setDesc(highlightFields.get("desc").fragments()[0].toString());
            }

            if (highlightFields.containsKey("address")) {
                user.setAddress(highlightFields.get("address").fragments()[0].toString());
            }

            userList.add(user);
        }

        userList.forEach(System.out::println);
    }

    private String getId() throws IOException {
        test_1_Add();
        SearchRequest searchRequest = new SearchRequest(ES_USER_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.termQuery("name.keyword", "?????????????????????"))
                .size(1);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = es.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        return Arrays.stream(hits).map(SearchHit::getId).findFirst().orElse(null);
    }
}
