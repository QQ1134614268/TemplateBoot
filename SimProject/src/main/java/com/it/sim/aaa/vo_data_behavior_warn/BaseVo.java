package com.it.sim.aaa.vo_data_behavior_warn;

import com.it.sim.aaa.vo_2_ship.ShipVO;

/**
 * @date 2022-12-23 10:08
 */
public class BaseVo {
    Double latitude;
    Double longitude;

    public BaseVo(ShipVO shipVO) {
        this.latitude = shipVO.getLatitude();
        this.longitude = shipVO.getLongitude();
    }
}
