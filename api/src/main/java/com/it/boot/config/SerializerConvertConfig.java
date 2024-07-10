package com.it.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.it.boot.config.Conf.DATE_TIME_FORMAT;

@Configuration
public class SerializerConvertConfig {

    @Bean
    public Converter<String, Date> dateConverter() {
        return source -> {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
            try {
                return sdf.parse(source);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date format. Should be '" + DATE_TIME_FORMAT + "'", e);
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return LocalDate::parse;
    }

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return LocalDateTime::parse;
    }

}