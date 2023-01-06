package com.it.sim.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.sim.json.dto.Result;
import com.it.sim.json.dto.Country;
import com.it.sim.json.dto.Book;
import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestJackson {
    // 时间 会有差8小时问题, 同springboot中转换时间问题; TypeReference 类似gson中的; 有注解区别转化
    public static ObjectMapper mapper = new ObjectMapper();
    /**
     * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
     * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
     * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
     * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
     * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
     */
    @Test
    public void run() throws IOException {
        Country country = BuildDataUtil.createData(Country.class);
        String json = mapper.writeValueAsString(country);
        System.out.println(json);
        // ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
        Country country2 = mapper.readValue(json, Country.class);
        System.out.println(country2);
    }
    @Test
    public void testTypeReference2() throws IOException {
        //创建对象并设置值
        Result<List<Book>> data = new Result<>();
        data.setCode("200");
        ArrayList<Book> list = new ArrayList<>();
        list.add(BuildDataUtil.createData(Book.class));
        list.add(BuildDataUtil.createData(Book.class));
        data.setData(list);

        ObjectMapper objectMapper = new ObjectMapper();
        //序列化
        String string = objectMapper.writeValueAsString(data);
        System.out.println(string);


        //不使用TypeReference
        Result<?> o2 = objectMapper.readValue(string, Result.class);
        System.out.println(o2);

        //使用TypeReference
        Result<ArrayList<Book>> o = objectMapper.readValue(string, new TypeReference<Result<ArrayList<Book>>>() {
        });
        System.out.println(o);
    }
}

