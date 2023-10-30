package com.it.sim.test.time;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.sim.config.TimeConf;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestDate {

    @Test
    public void test1() {
        // 获取不同格式化风格和中国环境的日期
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);

        // 获取不同格式化风格和中国环境的时间
        DateFormat df5 = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat df6 = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat df7 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df8 = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);

        // 将不同格式化风格的日期格式化为日期字符串
        String date1 = df1.format(new Date());
        String date2 = df2.format(new Date());
        String date3 = df3.format(new Date());
        String date4 = df4.format(new Date());

        // 将不同格式化风格的时间格式化为时间字符串
        String time1 = df5.format(new Date());
        String time2 = df6.format(new Date());
        String time3 = df7.format(new Date());
        String time4 = df8.format(new Date());

        // 输出日期
        System.out.println("SHORT：" + date1 + " " + time1);
        System.out.println("FULL：" + date2 + " " + time2);
        System.out.println("MEDIUM：" + date3 + " " + time3);
        System.out.println("LONG：" + date4 + " " + time4);

        DateFormat df = DateFormat.getInstance();
        String str = df.format(new Date());
        System.out.println("默认: " + str);

        TimeZone tz = TimeZone.getTimeZone("Asia/Chongqing");
        df.setTimeZone(tz);
        str = df.format(new Date());
        System.out.println(tz.getID() + " :" + str);

    }

    @Test
    public void test2() {
        // date为2013-09-19 14:22:30
        Date date = new Date();

        // 创建“简体中文”的Locale
        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
        // 创建“英文/美国”的Locale
        Locale localeUS = new Locale("en", "US");

        // 获取“简体中文”对应的date字符串
        String cn = DateFormat.getDateInstance(DateFormat.MEDIUM, localeCN).format(date);
        // 获取“英文/美国”对应的date字符串
        String us = DateFormat.getDateInstance(DateFormat.MEDIUM, localeUS).format(date);

        System.out.printf("cn=%s\nus=%s\n", cn, us);

    }

    @Test
    public void test3() throws ParseException, JsonProcessingException {
        @Data
        @AllArgsConstructor
        class User {
            @JsonFormat(pattern = TimeConf.YMD_HMS)
            private Date date;
        }
        String date_time_str = "2000-01-01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat(TimeConf.YMD_HMS);// 格式化时间
        Date date = sdf.parse(date_time_str);

        ObjectMapper objectMapper = new ObjectMapper();
        String json2 = objectMapper.writeValueAsString(new User(date));
        System.out.println(json2);
    }

}
