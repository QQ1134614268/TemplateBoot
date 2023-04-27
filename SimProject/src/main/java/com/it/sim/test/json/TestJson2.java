package com.it.sim.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.it.sim.test.json.dto.City;
import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

public class TestJson2 {

    @Test
    public void test2() {
        // todo @type在类型转换  fasterJson jackson
        City city = BuildDataUtil.createData(City.class);
        String jsonWithType = JSON.toJSONString(city, SerializerFeature.WriteClassName);

        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        JSONObject jsonObject = JSON.parseObject(jsonWithType);

        System.out.println(jsonObject.getString("createBy"));
        System.out.println(jsonObject.getString("createTime"));
        System.out.println(jsonObject.getString("@type"));

    }
}

