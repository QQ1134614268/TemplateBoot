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
public class UnopenedAis implements L1ModelStrategy {

    String name = "未开ais";

    Boolean openAisFlag = false;

    List<AreaVo> areaVoList = MockApi.mockAreaDataList();

    // 是否预警
    Boolean isWarn = false;

    public void issuedOrder(ShipVO shipVO) {

        // 前置, 前往区域
        if (!areaVoList.isEmpty()) {
            // 产生6个数据
            goTO(shipVO, areaVoList.get(0), false);
        }

        // 执行阶段

        // 关闭ais
        shipVO.setIsOpenAis(openAisFlag);

        // 运动--触发预警
        goTO(shipVO, areaVoList.get(0), true);
    }
}
