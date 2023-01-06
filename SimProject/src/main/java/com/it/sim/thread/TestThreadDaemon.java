package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @date 2022-10-11 11:54
 */
@Slf4j
public class TestThreadDaemon {
    // isDaemon

    // 子线程一旦加了sleep语句，子线程就不输出打印了？
    // 取决与是否是守护线程，守护线程主线程执行完就会自动退出，非守护线程主线程执行完还会继续执行。
    // CompletableFuture默认使用的线程池就是ForkJoinPool，线程都是守护线程，所以不会打印。
    public static void main(String[] args) {
        new TestThreadDaemon().thread2();
    }

    @Test
    public void thread2() {
        // 单元测试:多线程方法不执行深度解析
        // 核心问题在于：在子线程结束执行前并未将主线程阻塞，主线程结束后，jvm直接退出

        // @Test执行:  test方法运行在主线程中，外层函数执行完test等操作后执行System.exit来退出虚拟机，这个时候thread可能还没执行完，就被销毁了。
        // Main方法: 启动完thread后，主线程结束，但是只有还有普通线程（非守护线程），虚拟机就不会主动退出，
        //   而我们也没有写代码让虚拟机退出，因此虚拟机需等待thread运行完毕才退出。因此打印出了子线程结束。
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                log.info("Thread: " + Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("main: " + Thread.currentThread().isDaemon());
    }

    @Test
    public void thread() {

        System.out.println("主");
        CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
            System.out.println("子");
            System.out.println("" + Thread.currentThread().isDaemon());
        }).whenComplete((r, e) -> System.out.println("b"));
    }
}
