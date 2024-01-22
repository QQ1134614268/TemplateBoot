package com.it.feign.config;

import feign.codec.Decoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * 解决 feign 只序列化Content-Type: application/json;
 * <p>
 * Caused by: org.springframework.web.client.UnknownContentTypeException: Could not extract response: no suitable HttpMessageConverter found for response type [class com.alibaba.fastjson2.JSONObject] and content type [text/plain;charset=UTF-8]
 * <p>
 * 返回结果: 获取Decoder, 解析数据
 */
// @Configuration // 或者添加到 @FeignClient(configuration = FeignTextPlainConfig.class)
public class FeignTextPlainConfig {

    static class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        @Override
        public void setSupportedMediaTypes(@NonNull List<MediaType> supportedMediaTypes) {
            super.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        }
    }

    @Bean
    public Decoder textPlainDecoder() {
        System.out.println("textPlainDecoder");
        return new SpringDecoder(() -> new HttpMessageConverters(new CustomMappingJackson2HttpMessageConverter()));
    }
}