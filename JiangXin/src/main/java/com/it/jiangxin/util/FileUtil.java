package com.it.jiangxin.util;

import java.util.UUID;

public class FileUtil {

    public static String getFileName(String fileName) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid + getFileType(fileName);
    }

    public static String getFileType(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
