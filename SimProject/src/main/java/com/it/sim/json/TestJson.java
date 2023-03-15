package com.it.sim.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.it.sim.json.dto.City;
import com.it.sim.json.dto.Country;
import com.it.sim.json.dto.Province;
import com.it.sim.json.dto.Result;
import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//alibaba.fastjson.JSON;:   java对象转换成JSON字符串，若想要获得key、value键值对，只需要对象中有getXxx(  )方法即可！！！！
//  额外增加了一个get方法，以让Student对象转成json格式的时候多一个"idName"的字段！
//google.gson.Gson :   应该是利用反射,获取能反射的值
public class TestJson {

    @Test
    public void getGson() {
        Result<List<Country>> result = getData();
        Gson gson = new Gson();
        String json = gson.toJson(result);
        System.out.println(json);

        Result<List<Country>> result2 = gson.fromJson(json, new TypeToken<Result<List<Country>>>() {
        }.getType());
        String json2 = gson.toJson(result2);
        System.out.println(json2);
        System.out.println("==" + Objects.equals(result, result2));
        System.out.println("==" + Objects.equals(json2, json));
    }

    @Test
    public void testFastjson() {
        Result<List<Country>> result = getData();
        String json = JSON.toJSONString(result);
        System.out.println(json);
        // JSON.parse(json, User.class);
        // JSON.parseArray(json, User.class);
        Result<List<Country>> result1 = JSON.parseObject(json, new TypeReference<Result<List<Country>>>() {
        }.getType());
        String json2 = JSON.toJSONString(result1);
        System.out.println(json2);
        System.out.println("==" + Objects.equals(json2, json));
    }

    @Test
    public void testJackson() throws IOException {

        Result<List<Country>> country = getData();

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(country);
        System.out.println(json);

        Result<List<Country>> country2 = mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<Result<List<Country>>>() {
        });

        String json2 = mapper.writeValueAsString(country2);
        System.out.println(json2);
        System.out.println("==" + Objects.equals(json2, json));
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

