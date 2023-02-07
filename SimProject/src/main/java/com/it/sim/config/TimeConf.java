package com.it.sim.config;

import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public interface TimeConf {
    String YYYY_MM_DD = "yyyy-MM-dd";
    String HH_MM_SS = "HH:mm:ss";
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    String REDIS_PREFIX_VERIFICATION_CODE = "VERIFICATION_CODE-";

    DateTimeFormatter Fmt_YYYY_MM_DD = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    DateTimeFormatter Fmt_YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
}
