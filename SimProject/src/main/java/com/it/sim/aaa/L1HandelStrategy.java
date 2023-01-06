package com.it.sim.aaa;

import lombok.Data;

/**
 * @date 2022-12-16 11:12
 */

public interface L1HandelStrategy {
    String level = "1";

    default String getHandelName() {
        return "HandelStrategy";
    }

    default String getLevel() {
        return level;
    }

    @Data
    class VideoTrackL1HandelStrategy implements L1HandelStrategy {
        String handelName = "视频跟踪";
        String level = "1";

        L2SelectStrategy l2SelectStrategy;
    }

    @Data
    class UnmannedShipL1HandelStrategy implements L1HandelStrategy {
        String handelName = "无人船";
        String level = "1";
        L2SelectStrategy l2SelectStrategy;
    }

}

