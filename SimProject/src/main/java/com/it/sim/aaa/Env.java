package com.it.sim.aaa;

import com.it.sim.aaa.vo_data_behavior_warn.AisVo;
import com.it.sim.aaa.vo_data_behavior_warn.BehaviorVo;
import com.it.sim.aaa.vo_data_behavior_warn.RadarVo;
import com.it.sim.aaa.vo_data_behavior_warn.WarnVo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @date 2022-12-19 14:13
 */
public class Env implements IEnv {

    // envMap, 获取所有对象, 弱引用
    WeakHashMap<String, Object> envMap;

  public   static List<RadarVo> radarTable =new ArrayList<>();
    public static List<AisVo> aisVos =new ArrayList<>();
    public  static List<BehaviorVo> behaviorVos =new ArrayList<>();
    public static List<WarnVo> warnVoList =new ArrayList<>();


    // 属性
    String uid;
    String createTime;

    String datetime;
    String position;

    String speed;


    // 模型 case1 单一条件
    String unopenedAis; // 未开ais
    String overSpeed; // 超速
    String lowSpeed; // 怠速

    // 模型 case2 聚合条件,
    String and; // 与运算
    String or; // 或运算
    String following; // 尾随


    // 输出, 定时, 责任链
    String behavior; // 行为
    String warn; // 预警

    // 预案
    Method select;
    Method beSelectedResource;

    // 海域环境
    String monitorArea;

}
