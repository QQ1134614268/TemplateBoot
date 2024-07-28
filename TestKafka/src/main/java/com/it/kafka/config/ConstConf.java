package com.it.kafka.config;

import java.time.format.DateTimeFormatter;

/**
 * @date 2022-09-20 13:52
 */
public interface ConstConf {
    String YYYY_MM_DD = "yyyy-MM-dd";
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    DateTimeFormatter FORMATTER_YMD = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    DateTimeFormatter FORMATTER_YMD_HMS = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);

    String USER_TOPIC = "USER_TOPIC_1";
    String USER_TOPIC_OBJECT = "USER_TOPIC_OBJECT";
    String USER_TOPIC_WITH_TYPE_ID = "USER_TOPIC_WITH_TYPE_ID";
    String STREAM_OUT_TOPIC_1 = "STREAM_OUT_TOPIC_1";
    String STREAM_OUT_TOPIC_2 = "STREAM_OUT_TOPIC_2";

}
