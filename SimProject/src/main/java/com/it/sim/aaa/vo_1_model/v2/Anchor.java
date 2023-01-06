package com.it.sim.aaa.vo_1_model.v2;

import com.it.sim.aaa.vo_1_model.L1ModelStrategy;
import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

/**
 * @date 2022-12-22 18:14
 */
@Data
public class Anchor implements L1ModelStrategy {

    String name = "海面停泊";

    @Override
    public void issuedOrder(ShipVO shipVO) {
        // 岸边, 指定地点 todo

    }
}
