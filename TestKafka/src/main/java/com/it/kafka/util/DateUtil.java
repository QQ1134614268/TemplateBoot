package com.it.kafka.util;

import com.it.kafka.config.ConstConf;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2022-09-20 13:51
 */
public class DateUtil {

    /**
     * 把日期对象根据生成指定格式的字符串
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 把日期字符串生成指定格式的日期对象
     */
    public static Date formatString(String str, String format) throws Exception {
        if ("".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    /**
     * 生成当前年月日字符串
     */
    public static String getCurrentDateStr() {
        return formatDate(new Date(), ConstConf.YYYY_MM_DD);
    }

    /**
     * 生成当前年月日 时分秒字符串
     */
    public static String getCurrentDateTimeStr() {
        return formatDate(new Date(), ConstConf.YYYY_MM_DD_HH_MM_SS);
    }

}
