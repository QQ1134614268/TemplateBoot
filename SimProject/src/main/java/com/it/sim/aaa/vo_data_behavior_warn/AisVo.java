package com.it.sim.aaa.vo_data_behavior_warn;

import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

/**
 * @date 2022-12-22 16:30
 */
@Data
public class AisVo extends ShipVO {

    public AisVo(ShipVO shipVO) {
        this.setLatitude(shipVO.getLatitude());
        this.setLongitude(shipVO.getLongitude());
    }

}
