package com.it.sim.thread;

/**
 * @date 2022/8/22
 */
public class TestThreadGroup {
    public static void main(String[] args) throws InterruptedException {
       new TestThreadGroup().crate();
       while (true){
        // Thread.getAllStackTraces();
        // Thread.activeCount(); // 等于 currentThread().getThreadGroup().activeCount();
        // Thread.currentThread().getName(); .getStackTrace(); .getThreadGroup();
        Thread.currentThread().getThreadGroup().list();
        Thread.sleep(30000);
       }
    }

    private void crate() {
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(1);
        }
        new Thread(this::crate).start();
        new Thread(this::crate).start();
    }
}
