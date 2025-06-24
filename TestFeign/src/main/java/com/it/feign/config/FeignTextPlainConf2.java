package com.it.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用@Configuration: 全局配置; 影响普通的接口 contentType为 text/plain; 不建议使用
 */
// @Configuration // 全局配置
public class FeignTextPlainConf2 {

    @Bean // HttpMessageConverter: 影响整个项目; 普通的接口 contentType为 text/plain; 不建议使用
    public MappingJackson2HttpMessageConverter customMappingJackson2HttpMessageConverter() {
        return new CustomMappingJackson2HttpMessageConverter();
    }

    static class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        @Override
        public void setSupportedMediaTypes(@NonNull List<MediaType> supportedMediaTypes) {
            ArrayList<MediaType> types = new ArrayList<>(supportedMediaTypes);
            types.add(MediaType.TEXT_PLAIN);
            super.setSupportedMediaTypes(types);
        }
    }
}