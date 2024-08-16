package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2023-02-27 11:08
 */
@Slf4j
public class ThreadUtils {


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            log.error("睡眠异常", e);
        }
    }

}
