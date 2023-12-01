package com.it.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;
import java.util.List;

// @Configuration
public class FeignTextPlainConfig2 {
    @Bean
    Logger.Level feignLoggerLevel() {
        // 这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }

    static class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        @Override
        public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
            super.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        }
        // public CustomMappingJackson2HttpMessageConverter() {
        //     super.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        // }
    }

    @Bean // 解决feign只序列化Content-Type: application/json,增加text/plain todo 导致普通接口接口的 Content-Type: text/plain
    public MappingJackson2HttpMessageConverter customMappingJackson2HttpMessageConverter() {
        return new CustomMappingJackson2HttpMessageConverter();
    }
}