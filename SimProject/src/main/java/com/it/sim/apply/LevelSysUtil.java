package com.it.sim.apply;

/**
 * @date 2023-06-05 11:53
 */
public class LevelSysUtil {
    // 等级系统 -- level 转等级
    public static double getSecondsByLevel(int level) {
        int max = 9;
        double len = Math.PI * level / max;
        return Math.sin(Math.toDegrees(len));
    }
}
