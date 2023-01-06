package com.it.sim.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDemo4 {

    int i = 0;
    // 类A中的内部类B的函数print()调用了定义在A中的参数a,这个时候如果不加final，就会出错。
    // 因为内部类被编译的时候会生成一个单独的内部类的.class文件，这个文件并不与外部类在同一class文件中。
    // 如果内部类改掉了这些参数的值也不可能影响到原参数，然而这样却失去了参数的一致性，因为从编程人员的角度来看他们是同一个东西，
    // 如果编程人员在程序设计的时候在内部类中改掉参数的值，
    // 但是外部调用的时候又发现值其实没有被改掉，这就让人非常的难以理解和接受，为了避免这种尴尬的问题存在，
    // 所以编译器设计人员把内部类能够使用的参数设定为必须是final来规避这种莫名其妙错误的存在。

    @Test
    public void test3() {


        // final int[] i = {0};
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            i = i + 1;
            // i[0] = i[0] + 1;
        });
        System.out.println(i);
        //    不确定的结果
    }

    public static void main(String[] args) {
        final CountDownLatch count = new CountDownLatch(100);
        //java的线程池
        int j = 2;

        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> System.out.println(j));
        }
    }
}
