package com.it.boot.config.serializer;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.format.DateTimeFormatter;

import static com.it.boot.config.Conf.*;

@Configuration
public class SerializerConfig {

    // /**
    //  * string转 localDate
    //  */
    // @Bean
    // public Converter<String, LocalDate> localDateConverter() { // todo
    //     return new Converter<String, LocalDate>() {
    //         @Override
    //         public LocalDate convert(String source) {
    //             return LocalDate.parse(source);
    //         }
    //     };
    // }
    //
    // /**
    //  * string转 localDatetime
    //  */
    // @Bean
    // public Converter<String, LocalDateTime> localDateTimeConverter() {
    //     return new Converter<String, LocalDateTime>() {
    //         @Override
    //         public LocalDateTime convert(String source) {
    //             return LocalDateTime.parse(source);
    //         }
    //     };
    // }

    // @Bean
    // public LocalDateSerializer localDateSerializer() {
    //     return new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    // }
    //
    // @Bean
    // public LocalDateDeserializer localDateDeserializer() {
    //     return new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    // }

    /**
     * LocalDateTime 等 序列化
     */
    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        module.addSerializer(new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        module.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        om.registerModule(module);
        return om;
    }
}