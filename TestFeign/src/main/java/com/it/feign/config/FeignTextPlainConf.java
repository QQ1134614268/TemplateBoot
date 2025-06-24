package com.it.feign.config;

import feign.codec.Decoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 类配置: 添加到 @FeignClient(configuration = {FeignTextPlainConf.class})
 */
// @Configuration // 全局配置, 所有feign
public class FeignTextPlainConf {

    @Bean //  feign.codec.Decoder 仅涉及feign模块
    public Decoder textPlainDecoder() {
        return new SpringDecoder(() -> new HttpMessageConverters(new CustomMappingJackson2HttpMessageConverter()));
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