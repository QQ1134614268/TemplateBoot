package com.it.sim.aaa;

import java.util.List;

/**
 * @date 2022-12-16 11:12
 */
@FunctionalInterface
public interface L2SelectStrategy {

    // 获取所有选择项 民警1,2,3 无人船1,2,3 喇叭1,2,3; 真实数据脱敏,生成,
    default <T> T getAllSelect() {
        return null;
    }

    void select();

    class NearSelectStrategy {

        <T extends IPosition> void select(List<T> list) {
            return;
        }
    }

    class AssignSelectStrategy {
        <T extends IPosition> void select(List<T> list) {
            return;
        }
    }
}
