package com.it.sim.jvm.javamemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

// -Xmx20M -XX:MaxDirectMemorySize=10M
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
// Exception in thread "main" java.lang.OutOfMemoryError
// 	at sun.misc.Unsafe.allocateMemory(Native Method)
// 	at com.it.JavaMemory.DirectMemoryOOM.main(com.it.JavaMemory.DirectMemoryOOM.java:14)