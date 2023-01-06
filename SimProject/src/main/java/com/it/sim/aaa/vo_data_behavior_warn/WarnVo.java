package com.it.sim.aaa.vo_data_behavior_warn;

import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

/**
 * @date 2022-12-22 16:30
 */
@Data
public class WarnVo {

    ShipVO shipVO ;
    public WarnVo(ShipVO shipVO) {
        this.shipVO = shipVO ;
    }
}
