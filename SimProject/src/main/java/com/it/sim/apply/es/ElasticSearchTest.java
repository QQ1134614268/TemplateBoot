package com.it.sim.apply.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElasticSearchTest {
    static JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper();// json映射器
    ElasticsearchTransport transport;
    ElasticsearchClient es;
    String index = "products";

    @Before
    public void startup() {
        RestClient restClient = RestClient
                .builder(new HttpHost("127.0.0.1", 9200, "http"))
                .build();
        transport = new RestClientTransport(restClient, jacksonJsonpMapper);// 创建传输层
        es = new ElasticsearchClient(transport);
    }

    @After
    public void after() throws IOException {
        transport.close();
        System.out.println("关闭传输层成功");
    }

    @Test
    public void test_1_createIndex() throws IOException {// 创建索引
        ExistsRequest existsRequest = new ExistsRequest.Builder().index(index).build();
        BooleanResponse res = es.indices().exists(existsRequest);
        if (res.value()) {
            DeleteIndexRequest r = new DeleteIndexRequest.Builder().index(index).build();
            es.indices().delete(r);
        }
        CreateIndexResponse createIndexResponse = es.indices().create(c -> c.index(index));
        System.out.println("创建索引操作测试:" + createIndexResponse.acknowledged());
    }

    @Test
    public void test_2_createDocument() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "product 0");
        map.put("price", String.valueOf(50 + (int) (Math.random() * 500)));
        CreateResponse createResponse =
                es.create(CreateRequest.of(c -> c.index(index).id("1").document(map)));// id已存在则会创建失败
        System.out.println("创建单个文档测试:" + createResponse.result().jsonValue());
    }

    @Test
    public void test_3_bulkCreateDocuments() throws IOException {// 批处理创建多个文档
        List<BulkOperation> list = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "product " + i);
            map.put("price", String.valueOf(50 + (int) (Math.random() * 500)));
            int id = i;
            list.add(BulkOperation.of(c -> c.create(e -> e.index(index).id(String.valueOf(id)).document(map))));
        }
        BulkResponse bulkResponse =
                es.bulk(new BulkRequest.Builder().index(index).operations(list).build());//.type("_doc")加不加都可以
        System.out.println("批量创建多个文档测试:(例:查看第一个文档创建结果)" + bulkResponse.items()
                .get(0)
                .result());// created
    }

    @Test
    public void test_4_searchIndex() throws IOException {
        SearchResponse<Object> searchResponse = es.search(new SearchRequest.Builder().index(index)
                .build(), Object.class);
        List<Object> result = new ArrayList<>();
        for (Hit<Object> hit : searchResponse.hits().hits()) {
            result.add(hit.source());
        }
        System.out.println(result);//[{price=206, name=product 0}, {price=548, name=product 5},...]
    }

    @Test
    public void test_5_searchInRangeOfPrice() throws IOException {
        // 从products索引中搜索价格字段值>=300&&<=500的文档
        SearchResponse<Object> searchResponse =
                es.search(
                        s -> s.index(index).query(
                                c -> c.bool(
                                        b -> b.filter(
                                                q -> q.range(
                                                        v -> v.field("price")
                                                                .gte(JsonData.of("300"))
                                                                .lte(JsonData.of("500"))))))
                        , Object.class);
        List<Hit<Object>> list = searchResponse.hits().hits();
        List<Object> result = new ArrayList<>();
        for (Hit<Object> hit : list) {
            result.add(hit.source());
        }
        System.out.println(result);//[{price=396, name=product 6}, {price=483, name=product 8}, {price=393, name=product 9}, ...]
    }

    @Test
    public void test_6_deleteDocument() throws IOException {// 删除 request [DELETE http://localhost:9200/products/_doc/1]
        System.out.println("查看删除是否成功:" + es.delete(d -> d.index(index).id("1")).result().jsonValue());// deleted
    }
}