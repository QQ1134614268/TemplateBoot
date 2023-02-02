package com.it.sim.jvm.javamemory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
// 常量池移到堆中了

// Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=1M; support was removed in 8.0
// Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=1M; support was removed in 8.0

// -XX:PermSize=10M -XX:MaxPermSize=10M
@SuppressWarnings("StringBufferReplaceableByString")
public class RuntimeConstantPoolOOMTest {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }

    @SuppressWarnings("StringEquality")
    @Test
    public void testIntern() {

        // intern 在jdk1.7的常量池中 记录首次出现的引用
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        // true

        String str2 = new StringBuilder("ja").append("va").toString();
        // toString之前,常量池中存在 java 字符串
        System.out.println(str2.intern() == str2);
        // false
    }
}
