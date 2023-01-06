package com.it.sim.thread;


public class TestThreadSynchronized {

    public static void main(String[] args) {
        // 当一个线程进入一个对象的一个 synchronized 方法后，其它线程是否可进入此对象的其它方法?

        new Thread(new Thread1()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }


    static class Thread1 implements Runnable {

        @Override
        public void run() {
            //由于这里的 Thread1和下面的 Thread2内部 run 方法要用同一对象作为监视器，
            // 我们这里不能用 this，因为在 Thread2里面的 this 和这个 Thread1的 this 不是同一个对象。
            // 我们用MultiThread.class 这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对象。
            synchronized (TestThreadSynchronized.class) {
                System.out.println("enterThread1...");
                System.out.println("thread1is waiting");
                try {
                    //释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了 synchronized 关键字管辖的代码范围，
                    // 另一种方式就是在 synchronized 关键字管辖的代码内部调用监视器对象的 wait 方法。这里，使用 wait 方法释放锁。
                    TestThreadSynchronized.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1is going on...");
                System.out.println("thread1is being over!");
            }
        }

    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (TestThreadSynchronized.class) {

                System.out.println("enterThread2...");

                System.out.println("thread2notify other thread can release wait status..");
                //由于 notify 方法并不释放锁，即使 thread2调用下面的 sleep 方法休息了10毫秒，但 thread1仍然不会执行，
                // 因为 thread2没有释放锁，所以 Thread1无法得不到锁。
                TestThreadSynchronized.class.notify();
                System.out.println("thread2is sleeping ten millisecond...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2is going on...");
                System.out.println("thread2is being over!");

            }
        }
    }
}
