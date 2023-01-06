package com.it.sim.aaa;

import com.it.sim.aaa.vo_1_model.L1ModelStrategy;
import com.it.sim.aaa.vo_1_model.LowSpeed;
import com.it.sim.aaa.vo_1_model.OverSpeed;
import com.it.sim.aaa.vo_1_model.UnopenedAis;
import com.it.sim.aaa.vo_2_ship.AreaVo;
import com.it.sim.aaa.vo_2_ship.LineVo;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022-12-22 17:55
 */
public class MockApi {

    public static List<L1ModelStrategy> mockModel() {

        List<L1ModelStrategy> l1ModelStrategies = new ArrayList<>();

        UnopenedAis unopenedAis = new UnopenedAis();
        l1ModelStrategies.add(unopenedAis);

        l1ModelStrategies.add(new OverSpeed());
        l1ModelStrategies.add(new LowSpeed());
        return l1ModelStrategies;
    }

    // Vo
    public static List<AreaVo> mockAreaDataList() {
        List<AreaVo> areaVoList = new ArrayList<>();
        areaVoList.add(new AreaVo(1, 2, 3, 4, 5, 6, 4, 5));
        return areaVoList;
    }
    // Vo
    public static List<LineVo> mockLineDataList() {
        List<LineVo> areaVoList = new ArrayList<>();
        areaVoList.add(new LineVo());
        return areaVoList;
    }
}
