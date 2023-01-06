package com.it.sim.pc.monitor;

import lombok.Data;

/**
 * 内存信息
 * @author 188****4787
 * @date 2021/04/28 17:58
 */
@Data
public class Memory {

    // 总内存
    private double size;

    // 空闲内存
    private double freeSpace;

    /**
     * 获取已使用大小
     * @author 188****4787
     * @date 2021/04/28 17:58
     */
    public double getUsedSpace () {
        return size - freeSpace;
    }

    /**
     * 获取使用率
     * @author 188****4787
     * @date 2021/04/28 17:58
     */
    public double getUseRatio () {
        return getUsedSpace() / size * 100;
    }
}
