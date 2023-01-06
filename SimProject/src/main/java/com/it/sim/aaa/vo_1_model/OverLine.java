package com.it.sim.aaa.vo_1_model;

import com.it.sim.aaa.MockApi;
import com.it.sim.aaa.vo_2_ship.LineVo;
import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.Data;

import java.util.List;

/**
 * @date 2022-12-22 18:14
 */
@Data
public class OverLine implements L1ModelStrategy {

    String name = "越线";
    // 进出方式
    String entranceMode;

    List<LineVo> LineVoList = MockApi.mockLineDataList();

    // 是否预警
    Boolean isWarn = false;

    public void issuedOrder(ShipVO shipVO) {

        // 前置, 前往区域
        if (!LineVoList.isEmpty()) {
            // 产生6个数据
            goTO(shipVO, LineVoList.get(0), false);
        }

        // 执行阶段


        // 运动--触发预警
        goTO(shipVO, LineVoList.get(0), true);
    }
}
