package com.it.boot;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class HttpClientTest {
    Gson gson = new Gson();
    @Value("${server.port:80}")
    public Integer port;

    @Test
    public void printRequest() throws IOException {

        String url = String.format("http://127.0.0.1:%s/printRequest", port);
        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("name", "tom");
        paraMap.put("id", "1");
        String json = gson.toJson(paraMap);
        HashMap<String, String> headerMap = new HashMap<>();
        //		headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        headerMap.put("content-type", "application/json");

        //		String result = HttpClientUtil.execGet(url, paraMap, null);
        //		System.err.println(result);
        //
        StringEntity reqEntity;

        json = "name=tom&id=1";
        reqEntity = new StringEntity(json);// application/json
        reqEntity.setContentType("application/x-www-form-urlencoded");// 简单的字符串key-value对(大部分form－data的情况)，用application/x-www-form-urlencoded更简单有效

        //		json = gson.toJson(paraMap);
        //		reqEntity = new StringEntity(json.toString());// application/json
        //		reqEntity.setContentType("application/json");

        //		reqEntity.setContentType("multipart/form-data");// 文件必须使用的类型
        //		reqEntity.setContentType("text/xml");// 少
        //		reqEntity.setContentType("text/plain");// 少 默认使用的

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(reqEntity);

        RequestConfig requestConfig = RequestConfig.custom()
                // .setProxy(new HttpHost("127.0.0.1", 8888))
                .build();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
             CloseableHttpResponse response = httpClient.execute(httpPost);
             BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            int status = response.getStatusLine().getStatusCode(); // 状态码 返回值
            if (status != 200) {
                System.err.println("status:" + status);
            }
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.err.println(sb);
        }
    }
}
