package com.it.sim.aaa;

import com.it.sim.aaa.vo_2_ship.ShipVO;

/**
 * @date 2022-12-21 16:39
 */
public interface IMonitor {

    // 监控
    default void monitor() {

    }

    // 数据(ais radar) 的产生不是模拟, 而是根据规则生成
    default void produceData(ShipVO shipVO) {

    }
}
