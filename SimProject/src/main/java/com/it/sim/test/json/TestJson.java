package com.it.sim.test.json;

import com.alibaba.fastjson2.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.it.sim.test.json.dto.City;
import com.it.sim.test.json.dto.Country;
import com.it.sim.test.json.dto.Province;
import com.it.sim.test.json.dto.Result;
import com.it.sim.util.BuildDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//alibaba.fastjson.JSON;:   java对象转换成JSON字符串，若想要获得key、value键值对，只需要对象中有getXxx(  )方法即可！！！！
//  额外增加了一个get方法，以让Student对象转成json格式的时候多一个"idName"的字段！
//google.gson.Gson :   应该是利用反射,获取能反射的值
@Slf4j
public class TestJson {
    public static ObjectMapper mapper = new ObjectMapper();
    public static Gson gson = new Gson();//  new GsonBuilder().create();


    /**
     * 测试json框架的时间序列化, 反序列化
     */
    @Test
    public void testDate() throws JsonProcessingException {
        Date now = new Date();
        System.out.println(now);

        String jacksonStr = mapper.writeValueAsString(now);
        String fastjsonStr = JSON.toJSONString(now);
        String gsonStr = gson.toJson(now);

        System.out.println(jacksonStr);
        System.out.println(fastjsonStr);
        System.out.println(gsonStr);

        System.out.println(mapper.readValue(jacksonStr, Date.class));
        System.out.println(JSON.parseObject(fastjsonStr, Date.class));
        System.out.println(gson.fromJson(gsonStr, Date.class));

        String dateStr = "2000-10-10 00:00:00";
        try {
            System.out.println(mapper.readValue(dateStr, Date.class));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        try {
            System.out.println(JSON.parseObject(dateStr, Date.class));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        try {
            System.out.println(gson.fromJson(dateStr, Date.class));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Test
    public void testWithType() {
        // @type在类型转换  fasterJson jackson gson
        System.out.println(JSON.toJSONString(BuildDataUtil.createData(City.class), JSONWriter.Feature.WriteClassName));

        String noType = "{\"cityName\":\"test_kwZ2Q7P3\",\"id\":8912}";
        String withType = "{\"@type\":\"com.it.sim.test.json.dto.City\",\"cityName\":\"test_kwZ2Q7P3\",\"id\":8912}";

        JSONObject jsonObject = JSON.parseObject(withType); // JSONObject
        System.out.println(jsonObject.getClass());

        Object city1 = JSON.parseObject(withType, City.class); // 指定的类型
        System.out.println(city1.getClass());

        Object city = JSON.parseObject(withType, JSONReader.Feature.SupportAutoType);  // 没有类型, JSONObject
        System.out.println(city.getClass());

        // 指定类型, SupportAutoType;  指定的类型无效, 实际根据@type
        City city2 = JSON.parseObject(withType, City.class, JSONReader.Feature.SupportAutoType);
        System.out.println(city2.getClass());

        Object city3 = JSON.parseObject(withType, Province.class, JSONReader.Feature.SupportAutoType);
        System.out.println(city3.getClass());

        // JSONObject
        Object city4 = JSON.parseObject(noType, Object.class, JSONReader.Feature.SupportAutoType);
        System.out.println(city4.getClass());

        // Jackson
        ObjectMapper mapper = new ObjectMapper();
        // mapper.enable().writeValueAsString(city );


        // Gson
        // new GsonBuilder().registerTypeHierarchyAdapter().create().toJson()

    }

    @Test
    public void testTypeReference() throws JsonProcessingException {
        Result<List<Country>> data = getData();

        String jacksonStr = mapper.writeValueAsString(data);
        String gsonStr = gson.toJson(data);
        String fastjsonStr = JSON.toJSONString(data);

        System.out.println(jacksonStr);
        System.out.println(gsonStr);
        System.out.println(fastjsonStr);

        Result<List<Country>> result1 = gson.fromJson(jacksonStr, new TypeToken<Result<List<Country>>>() {
        }.getType());

        // JSON.parse(json, User.class);
        // JSON.parseArray(json, User.class);
        Result<List<Country>> result2 = JSON.parseObject(fastjsonStr, new TypeReference<Result<List<Country>>>() {
        }.getType());

        Result<List<Country>> result3 = mapper.readValue(gsonStr, new com.fasterxml.jackson.core.type.TypeReference<Result<List<Country>>>() {
        });
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    private static Result<List<Country>> getData() {
        Result<List<Country>> result = BuildDataUtil.createData(Result.class);
        result.setData(new ArrayList<>());

        for (int i = 0; i < 2; i++) {

            Country country = BuildDataUtil.createData(Country.class);
            result.getData().add(country);

            country.setProvinceList(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                Province province = BuildDataUtil.createData(Province.class);
                country.getProvinceList().add(province);

                for (int k = 0; k < 2; k++) {
                    province.setCityList(new ArrayList<>());
                    City city = BuildDataUtil.createData(City.class);
                    province.getCityList().add(city);
                }
            }
        }
        return result;
    }

}

