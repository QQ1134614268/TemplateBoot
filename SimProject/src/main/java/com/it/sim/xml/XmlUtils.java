package com.it.sim.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class XmlUtils {

    // xmlMapper.readTree()
    // xmlMapper.readValue()
    // xmlMapper.writeValueAsBytes()
    // xmlMapper.writeTree();
    public String toXml(Object obj) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("", e);
        }
        return null;
    }

    public <T> T fromXml(String str, Class<T> valueType) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(str.getBytes(StandardCharsets.UTF_8), valueType);
        } catch (IOException e) {
            log.error("", e);
        }
        return null;
    }
}
