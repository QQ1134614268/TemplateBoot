package com.it.sim.xml.jacksonxml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

/**
 * @date 2023-03-11 10:15
 */

public class XmlUtils {
    public static String toXml(Object o) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // xmlMapper.registerModule()
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        try {
            // .writerWithDefaultPrettyPrinter()
            return xmlMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromXml(String string, Class<T> clz) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        try {
            return xmlMapper.readValue(string.getBytes(), clz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
