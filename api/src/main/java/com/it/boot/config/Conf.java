package com.it.boot.config;

import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public interface Conf {
    String DATE_FORMAT = "yyyy-MM-dd";
    String TIME_FORMAT = "HH:mm:ss";
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    DateTimeFormatter FMT_DATE = DateTimeFormatter.ofPattern(DATE_FORMAT);
    DateTimeFormatter FMT_TIME = DateTimeFormatter.ofPattern(TIME_FORMAT);
    DateTimeFormatter FMT_DATE_TIME = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    String AUTHORIZATION = "authorization";

    String upload_path = Paths.get(System.getProperty("user.dir"), "data/upload").toString();
}
