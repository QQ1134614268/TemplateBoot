package com.it.jiangxin.config.constant;

public interface ConstConf {
    String DATE_FORMAT = "yyyy-MM-dd";
    String TIME_FORMAT = "HH:mm:ss";
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    String REDIS_PREFIX_VERIFICATION_CODE = "VERIFICATION_CODE-";

    String DATA_DIR = System.getProperty("user.dir");
    String UPLOAD_DIR = DATA_DIR + "/upload";

    String AUTHORIZATION = "Authorization";
    String Parent_ID_NULL = null;
    Integer Parent_ID_ZERO = 0;
    String LIST_SEPARATION = ",";

    int SIZE_ONE = 1;
    int LIST_FIRST = 0;
}
