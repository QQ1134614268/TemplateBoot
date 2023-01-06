package com.it.sim.aaa.vo_1_model;

import com.it.sim.aaa.MockApi;
import com.it.sim.aaa.vo_2_ship.AreaVo;
import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

import java.util.List;

/**
 * @date 2022-12-22 18:14
 */
@Data
public class OverSpeed implements L1ModelStrategy {

    String name = "超速";

    Double speed;

    // 持续时长
    Double lastTime;

    List<AreaVo> areaVoList = MockApi.mockAreaDataList();

    // 是否预警
    Boolean isWarn = false;


    public void issuedOrder(ShipVO shipVO) {


        // 前置, 前往区域
        if (!areaVoList.isEmpty()) {
            // 产生6个数据
            goTO(shipVO, areaVoList.get(0), isWarn);
        }

        // 执行阶段

        // 关闭ais
        shipVO.setSpeed(speed);

        // 运动--触发预警
        goTO(shipVO, areaVoList.get(0), isWarn);
    }
}
