package com.it.jiangxin.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static com.it.jiangxin.config.Conf.*;


@Configuration
public class SerializerObjectMapperConfig {
    /**
     * 处理使用json序列化, eg: 接收body中参数 或者返回值
     */
    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JavaTimeModule module = new JavaTimeModule();

        module.addSerializer(new DateSerializer());// false, new SimpleDateFormat(DATE_TIME_FORMAT)
        module.addDeserializer(Date.class, new DateDeserializers.DateDeserializer());//

        module.addSerializer(new LocalDateSerializer(FMT_DATE));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(FMT_DATE));

        module.addSerializer(new LocalTimeSerializer(FMT_TIME));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(FMT_TIME));

        module.addSerializer(new LocalDateTimeSerializer(FMT_DATE_TIME));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(FMT_DATE_TIME));

        objectMapper.registerModule(module);
        return objectMapper;
    }
}