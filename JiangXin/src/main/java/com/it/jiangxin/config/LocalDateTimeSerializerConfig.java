package com.it.jiangxin.config;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.it.jiangxin.config.constant.ConstConf;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalDateTimeSerializerConfig {

    /**
     * string转 localDate
     */
    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source);
            }
        };
    }

    /**
     * string转 localDatetime
     */
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source);
            }
        };
    }

    /**
     * 统一配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(ConstConf.DATE_TIME_FORMAT));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        return builder -> {
            builder.simpleDateFormat(ConstConf.DATE_TIME_FORMAT);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(ConstConf.DATE_FORMAT)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(ConstConf.DATE_TIME_FORMAT)));
            builder.modules(module);
        };
    }
}