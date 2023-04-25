package com.it.sim.thread;

import org.junit.Test;

public class TestThreadInterruptedException {
    @Test
    public void testSynchronized(){
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "线程开始了~");
            System.out.println(Thread.currentThread().getName()+ "线程结束了~");
        });
        thread.start();
        System.out.println("1" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("2" + thread.isInterrupted());
        System.out.println("测试结束");
    }

    @Test
    public void testSynchronized2(){
        Thread thread = new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+ "线程开始了~");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+"抛出了InterruptedException");
                    System.out.println("2" + isInterrupted());
                }
                System.out.println(Thread.currentThread().getName()+ "线程结束了~");
            }
        };
        thread.start();
        System.out.println("1" + thread.isInterrupted());
        thread.interrupt();

        System.out.println("测试结束");
    }
}