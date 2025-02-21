package com.it.sim.thread.lock;

public class TestWaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        // lock.wait(); // IllegalMonitorStateException

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("等待线程进入等待状态...");
                    lock.wait(); // 释放锁并等待
                    System.out.println("等待线程被唤醒，继续执行...");
                } catch (InterruptedException e) {
                    System.out.println("等待线程被中断");
                }
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("通知线程开始执行...");
                    Thread.sleep(2000); // 模拟一些操作
                    lock.notify(); // 唤醒等待的线程
                    System.out.println("通知线程发送了通知");
                } catch (InterruptedException e) {
                    System.out.println("通知线程被中断");
                }
            }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}