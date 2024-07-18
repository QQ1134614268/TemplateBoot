package com.it.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

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
        return new Converter<String, Date>() {
            @Override
            public Date convert(@NonNull String source) {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
                try {
                    return sdf.parse(source);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(String.format("格式不正确: %s", DATE_TIME_FORMAT), e);
                }
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(@NonNull String source) {
                return LocalDate.parse(source);
            }
        };
    }

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(@NonNull String source) {
                return LocalDateTime.parse(source);
            }
        };
    }

}