package com.it.sim.aaa.vo_data_behavior_warn;

import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

/**
 * @date 2022-12-22 16:36
 */
@Data
public class BehaviorVo {
    Double latitude;
    Double longitude;

    public BehaviorVo(ShipVO shipVO) {
        this.latitude = shipVO.getLatitude();
        this.longitude = shipVO.getLongitude();
    }
}
