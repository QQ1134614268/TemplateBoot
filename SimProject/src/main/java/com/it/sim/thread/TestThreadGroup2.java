package com.it.sim.thread;

public class TestThreadGroup2 {
    public static void main(String[] args) {
        String currentName = Thread.currentThread().getName();
        String groupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println("线程名称: " + currentName + ", 所在线程组: " + groupName);
        System.out.println();
 
        ThreadGroup threadGroup = new ThreadGroup("root线程组");
        Thread t1 = new Thread(threadGroup, new MyTask(), "线程-1");
        Thread t2 = new Thread(threadGroup, new MyTask(), "线程-2");
        Thread.currentThread().getThreadGroup().list();
        t1.start();
        Thread.currentThread().getThreadGroup().list();
        t2.start();
    }
}
 
class MyTask implements Runnable {
    @Override
    public void run() {
        String currentName = Thread.currentThread().getName();
        String groupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println("线程名称: " + currentName + ", 所在线程组: " + groupName);
    }
}