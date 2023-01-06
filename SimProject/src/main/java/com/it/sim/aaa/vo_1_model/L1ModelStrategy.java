package com.it.sim.aaa.vo_1_model;

import com.it.sim.aaa.Env;
import com.it.sim.aaa.MockApi;
import com.it.sim.aaa.vo_2_ship.AreaVo;
import com.it.sim.aaa.vo_2_ship.LineVo;
import com.it.sim.aaa.vo_2_ship.ShipVO;
import com.it.sim.aaa.vo_data_behavior_warn.AisVo;
import com.it.sim.aaa.vo_data_behavior_warn.BehaviorVo;
import com.it.sim.aaa.vo_data_behavior_warn.RadarVo;
import com.it.sim.aaa.vo_data_behavior_warn.WarnVo;

import java.util.List;

/**
 * @date 2022-12-16 11:12
 */

public interface L1ModelStrategy {

    void issuedOrder(ShipVO shipVO);

    // 组装成树; 前序遍历, 获取命令列表
    default List<L1ModelStrategy> preOrder() {
        return MockApi.mockModel();
    }

    // 船只向目标移动, 产生数据
    default void moveShip() {

    }

    default void goTO(ShipVO shipVo, LineVo lineVo, boolean isWarn) {
    }

    // 正常运行 | 预警
    default void goTO(ShipVO shipVo, AreaVo areaVo, Boolean isWarn) {

        double x = areaVo.getA1() - shipVo.getLatitude();
        double y = areaVo.getA2() - shipVo.getLongitude();

        // 生成6条数据
        int step = 6;
        for (int i = 1; i <= step; i++) {
            double x1 = x * i / step;
            double y1 = y * i / step;

            shipVo.setLatitude(x1);
            shipVo.setLongitude(y1);

            pAisData(shipVo);
            pRadarData(shipVo);

            if (isWarn) {
                pBehaviorData(shipVo);
                pWarnData(shipVo);
            }
        }
    }


    default void pAisData(ShipVO shipVO) {
        Env.aisVos.add(new AisVo(shipVO));
    }

    default void pRadarData(ShipVO shipVO) {
        Env.radarTable.add(new RadarVo(shipVO));
    }

    default void pBehaviorData(ShipVO shipVO) {
        Env.behaviorVos.add(new BehaviorVo(shipVO));
    }

    default void pWarnData(ShipVO shipVO) {
        Env.warnVoList.add(new WarnVo(shipVO));
    }
}

