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
    String STREAM_TOPIC = "STREAM_TOPIC";
    String STREAM_OUT_TOPIC = "STREAM_TOPIC";

    String GROUP_ID_1 = "Group_1";
    String GROUP_ID_2 = "Group_ID_2";
    String GROUP_ID_3 = "GROUP_ID_3";
    String GROUP_ID_4 = "GROUP_ID_4";
}
