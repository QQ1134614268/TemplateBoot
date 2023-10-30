package com.it.sim.config;

import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public interface TimeConf {
    String YMD = "yyyy-MM-dd";
    String HMS = "HH:mm:ss";
    String YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    DateTimeFormatter FMT_YMD = DateTimeFormatter.ofPattern(YMD);
    DateTimeFormatter FMT_YMD_HMS = DateTimeFormatter.ofPattern(YMD_HMS);
}
