package com.it.sim.aaa.vo_2_ship;

import com.it.sim.aaa.IPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2022-12-20 11:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipVO implements IPosition {
    String mmsi;
    Boolean isOpenAis;
    Double latitude;
    Double longitude;
    Double speed;


    // // 曾去区域
    // String arriveArea;

    String lastTime; // 持续时长

}
