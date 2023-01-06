package com.it.sim.aaa;

import com.it.sim.aaa.vo_2_ship.ShipVO;

/**
 * @date 2022-12-21 16:36
 */
public interface IRadar extends IMonitor {

    // // 模拟雷达, 获取船舶数据, 上报数据
    // default void getMonitorShipFormEnv(IEnv iEnv) {
    //
    // }

    // 船舶生产数据
    default void produceRadarData(ShipVO shipVO) {

    }
}
