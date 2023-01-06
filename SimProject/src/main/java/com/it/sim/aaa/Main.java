package com.it.sim.aaa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.it.sim.aaa.vo_1_model.L1ModelStrategy;
import com.it.sim.aaa.vo_2_ship.ShipVO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @date 2022-12-16 17:09
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 获取模型
        Long modelId = 1L;

        Path path = Paths.get("D:\\workspace\\javaSpace\\TemplateBoot\\SimProject\\src\\main\\java\\com\\it\\sim\\aaa\\data.json");

        List<String> lines = Files.readAllLines(path);
        String json = String.join("", lines);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray eventParams = jsonObject.getJSONArray("eventParams");

        System.out.println(eventParams);

        // 2. 聚合条件
        //  2.1 剪枝, 处理 与运算 或运算

        //  2.2 两船 并行 尾随, 一只船两只船

        // 3. 下发指令,并且触发模型, ais 船舶 一条数据N秒
        ShipVO shipVO = new ShipVO();
        shipVO.setLongitude(100d);
        shipVO.setLatitude(100d);

        L1ModelStrategy tree = new L1ModelStrategy() {
            @Override
            public void issuedOrder(ShipVO shipVO) {

            }
        };

        for (L1ModelStrategy l1ModelStrategy1 : tree.preOrder()) {
            // shipVO.acceptOrder(l1ModelStrategy1);
            l1ModelStrategy1.issuedOrder(shipVO);
        }

        // 4. 正常区域,


        // 5.
        IRadar iRadar;
        IAis iAis;

        // 输出结果

        log.info(JSON.toJSONString(Env.aisVos));
        log.info(JSON.toJSONString(Env.radarTable));
        log.info(JSON.toJSONString(Env.behaviorVos));
        log.info(JSON.toJSONString(Env.warnVoList));

        // 两个船
        // 时段
        // 曾去地
        // 区域
        //
    }
}
