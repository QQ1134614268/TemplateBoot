package com.it.sim.pc.monitor;

import lombok.Data;

/**
 * 磁盘信息
 * @author 188****4787
 * @date 2021/04/28 17:58
 */
@Data
public class Disk {

    // 磁盘名称
    private String name;

    // 盘符路径
    private String dir;

    // 文件系统类型
    private String fsType;

    // 总大小
    private double size;

    // 可用大小
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
