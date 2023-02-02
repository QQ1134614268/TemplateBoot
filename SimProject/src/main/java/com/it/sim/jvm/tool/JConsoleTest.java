package com.it.sim.jvm.tool;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {
    static class OOMObject {
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());

        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(Long.parseLong(processName.split("@")[0]));
        fillHeap(1000);
    }
}
