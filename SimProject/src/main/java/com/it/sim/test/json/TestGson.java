package com.it.sim.test.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.it.sim.test.json.dto.Book;
import com.it.sim.config.TimeConf;
import com.it.sim.util.BuildDataUtil;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zero DateTime 2018年4月28日 上午10:21:40
 */
public class TestGson {
    // str jsonObject object三者转换 jsonObject 得到 添加 删除属性

    @Test
    public void test() {
        Book book = BuildDataUtil.createData(Book.class);

        // GsonBuilder builder = new GsonBuilder();
        // builder.setDateFormat("yyyy-MM-dd");// yyyy-MM-dd HH:mm:ss.SSS
        // builder.disableHtmlEscaping
        // builder.registerTypeHierarchyAdapter
        // builder.setPrettyPrinting
        Gson gson = new Gson();
        String json = gson.toJson(book);

        System.out.println(json);

        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        // JsonArray jsonArray = jsonElement.getAsJsonArray();

        JsonElement propertyValue = jsonObject.get("id");
        System.out.println(propertyValue);

        JsonElement b = jsonObject.remove("id");
        System.out.println(b);

        jsonObject.addProperty("id", 2);

        boolean isContains = jsonObject.has("id");
        System.out.println(isContains);

    }

    @Test
    public void testTypeToken() {
        Gson gson = new Gson();
        String jsonList = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";
        Type type = new TypeToken<List<Book>>() {
        }.getType();
        ArrayList<Book> list = gson.fromJson(jsonList, type);
        System.out.println(list);

        List<?> list2 = gson.fromJson(jsonList, List.class);
        System.out.println(list2);
    }


    @Test
    public void testAddSerializer() {
        @Data
        class TestDemo {
            Date date;
            Calendar calendar;
        }
        TestDemo demo = new TestDemo();
        demo.setDate(new Date());
        demo.setCalendar(Calendar.getInstance());
        // 使用GsonBuilder来实例Gson，注册一个自定义处理Calendar日期类型序列化和反序列话的适配器，处理Calendar
        // 添加一个格式化Date类型的格式，处理Date类型
        Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer()).setDateFormat("yyyy-MM-dd").create();
        System.out.println(gson.toJson(demo));
    }

    static class CalendarSerializer implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {
        // 实现JsonSerializer接口的serialize（）方法，实现自定义序列化json
        @Override
        public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {
            if (src == null) {
                return null;
            }
            SimpleDateFormat format = new SimpleDateFormat(TimeConf.YYYY_MM_DD_HH_MM_SS);
            // JsonElement是一个抽象类，实现类分别是JsonObject和JsonPrimitive
            JsonObject ob = new JsonObject();
            ob.addProperty("date", format.format(src.getTime()));
            // return ob ;//结果{"id":0,"date":"2016-04-19","calendar":{"date":"2016-04-19 21:53:54"}}
            return new JsonPrimitive(format.format(src.getTime()));// 结果{"id":0,"date":"2016-04-19","calendar":"2016-04-19 21:54:31"}
        }

        // 实现JsonDeserializer接口的deserialize（）方法，实现自定义反序列化Object
        @Override
        public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = format.parse(json.getAsJsonObject().get("date").getAsString());
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(date);
                return gregorianCalendar;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
