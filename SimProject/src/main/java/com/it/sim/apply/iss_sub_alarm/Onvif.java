package com.it.sim.apply.iss_sub_alarm;

import java.util.Random;

/**
 * @date 2023-02-24 18:05
 */
interface Onvif {

    Onvif instance = new Onvif() {
    };

    Random random = new Random();

    default boolean login() {
        return getPercent();
    }


    default boolean logout() {
        return getPercent();
    }


    default boolean isLogin() {
        return getPercent();
    }


    default boolean subEvent() {
        return getPercent();

    }


    default boolean pullMsg() {
        return getPercent();
    }

    default boolean getPercent() {
        return random.nextInt(10) >= 2;
    }

}
