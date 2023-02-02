package com.it.netty.netty_long_keep.s;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class RadarInfo {
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private int id;
    private String longitude;
    private String latitude;
    private String direction;
    private String speed;
    private String size;
    private Date date;

    public static RadarInfo mockRadarInfo() {
        RadarInfo info = new RadarInfo();
        info.setId(atomicInteger.incrementAndGet());
        info.setLongitude("120");
        info.setLatitude("130");
        info.setDirection("west");
        info.setSpeed("20");
        info.setSize("2000");
        info.setDate(new Date());
        return info;
    }
}
