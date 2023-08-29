package com.it.sim.thread;

/**
 * @date 2023-02-27 11:08
 */
public class ThreadUtils {


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
