// package com.it.boot.config;
//
// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.converter.json.GsonHttpMessageConverter;
//
// import static com.it.boot.config.Config.DATE_TIME_FORMAT;
//
// @Configuration
// public class GsonConfig {
//
//     @Bean
//     GsonHttpMessageConverter gsonHttpMessageConverter() {
//         GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//         GsonBuilder builder = new GsonBuilder();
//         //设置时间格式 传给前端时(http), 所有都是这种格式
//         builder.setDateFormat(DATE_TIME_FORMAT);
//         Gson gson = builder.create();
//         converter.setGson(gson);
//         return converter;
//     }
// }