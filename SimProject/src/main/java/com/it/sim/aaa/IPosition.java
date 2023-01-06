package com.it.sim.aaa;

/**
 * @date 2022-12-16 11:33
 */
public interface IPosition {
    // 经度
    default Double getLongitude() {
        return null;
    }

    // 纬度
    default Double getLatitude() {
        return null;
    }
}
