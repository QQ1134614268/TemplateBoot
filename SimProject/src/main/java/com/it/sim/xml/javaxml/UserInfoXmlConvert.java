package com.it.sim.xml.javaxml;

import com.alibaba.fastjson2.JSON;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @date 2023-06-03 18:18
 */
public class UserInfoXmlConvert extends XmlAdapter<String, UserInfoXml> {

    @Override
    public UserInfoXml unmarshal(String v) throws Exception {
        return JSON.parseObject(v, UserInfoXml.class);
    }

    @Override
    public String marshal(UserInfoXml v) throws Exception {
        return JSON.toJSONString(v);
    }
}
