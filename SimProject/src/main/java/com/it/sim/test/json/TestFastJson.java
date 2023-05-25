package com.it.sim.test.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.it.sim.test.json.dto.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zero DateTime 2018年4月28日 上午10:24:33
 * @ :
 */
public class TestFastJson {

    @Test
    public void test() {
        // (6)通过json对象直接操作json
        String propertyName = "id";
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        Book book = JSON.parseObject(json, Book.class);
        System.out.println(book);

        JSONObject obj = JSON.parseObject(json);

        Object value = obj.get(propertyName);// 取值
        System.out.println(value);
        value = obj.put(propertyName, "update"); // 向json中添加属性
        System.out.println(value);
        value = obj.remove(propertyName);        // b)除去json中的某个属性
        System.out.println(value);
        Set<String> set = obj.keySet();
        // e)判断json中是否有属性
        boolean b = set.contains(propertyName);
        // String json = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    @Test
    public void testTypeReference() {
        // (5)json转换复杂的bean，比如List，Map
        String json = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";
        //将json转换成List
        List<Book> list = JSON.parseObject(json, new TypeReference<ArrayList<Book>>() {
        });
        System.out.println(list);
        //将json转换成Set
        Set<Book> set = JSON.parseObject(json, new TypeReference<HashSet<Book>>() {
        });
        // Set<Book> set = JSON.parseArray
        System.out.println(set);
    }
}
