package com.it.boot.config;

import java.nio.file.Paths;

public interface Conf {
    String DATE_FORMAT = "yyyy-MM-dd";
    String TIME_FORMAT = "HH:mm:ss";
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String AUTHORIZATION = "authorization";

    String upload_path = Paths.get(System.getProperty("user.dir"), "data/upload").toString();
}
