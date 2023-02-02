package com.it.sim.itree;


import java.util.Date;

@SuppressWarnings("unused")
public interface Human extends Id {
    String name = "";// 名称
    String value = ""; // 默认值

    String note = null; // 备注

    String status = null; // 状态
    Integer index = 0;// 集合中index

    Date datetime = null; // 时间
    String location = null; // 地点

    String env = null; // 环境,上下文背景

    default String getName() {
        return this.name;
    }

    default Date getDatetime() {
        return datetime;
    }
}