package com.it.sim.pc.monitor;

import lombok.Data;

/**
 * CPU信息
 * @author 188****4787
 * @date 2021/04/28 17:58
 */
@Data
public class CPU {

    // 逻辑核数
    private int logicalCount;

    // 物理核数
    private int physicalCount;

    // 用户使用率
    private double userRatio;

    // 系统使用率
    private double systemRatio;

    // 当前使用率
    private double useRatio;

    /**
     * 空闲率
     * @author 188****4787
     * @date 2021/04/28 17:58
     */
    public double getFreeRatio () {
        return 100.0 - useRatio;
    }
}
