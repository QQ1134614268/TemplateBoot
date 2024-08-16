package com.it.sim.thread;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestThread {

    @Test
    public void testThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("线程ID:{}", Thread.currentThread().getId());
            log.info("线程名称:{}", Thread.currentThread().getName());
            log.info("线程状态:{}", Thread.currentThread().getState());
            log.info("线程优先级:{}", Thread.currentThread().getPriority());
            log.info("是否守护线程:{}", Thread.currentThread().isDaemon());
            log.info("线程组:{}", Thread.currentThread().getThreadGroup());
            ThreadUtils.sleep(1);
            throw new RuntimeException("测试抛出异常");
        });
        thread.setUncaughtExceptionHandler((originThread, throwable) -> {
            log.error("线程ID:{},名称:{}", originThread.getId(), originThread.getName());
            log.error("throwable.getMessage():{}", throwable.getMessage());
        });
        // 启动线程
        thread.start();
        thread.join(); // 等待线程执行完
        log.info("子线程执行完毕");
    }

    @Test
    public void testThreadGroup() {
        Runnable runnable = () -> {
            String currentName = Thread.currentThread().getName();
            String groupName = Thread.currentThread().getThreadGroup().getName();
            log.info("线程名称: " + currentName + ", 所在线程组: " + groupName);
        };
        String currentName = Thread.currentThread().getName();
        String groupName = Thread.currentThread().getThreadGroup().getName();
        log.info("线程名称: " + currentName + ", 所在线程组: " + groupName);
        // Thread.getAllStackTraces();
        // Thread.activeCount(); // 等于 currentThread().getThreadGroup().activeCount();
        // Thread.currentThread().getName(); .getStackTrace(); .getThreadGroup();

        ThreadGroup threadGroup = new ThreadGroup("root线程组");
        Thread t1 = new Thread(threadGroup, runnable, "线程-1");
        Thread t2 = new Thread(threadGroup, runnable, "线程-2");
        Thread.currentThread().getThreadGroup().list();
        t1.start();
        Thread.currentThread().getThreadGroup().list();
        t2.start();
    }

    /**
     * 单元测试,子线程没有执行完解析: 主线程结束后，jvm直接退出
     * <br>
     * 守护线程的存在是依赖于主线程的。当 JVM 中仅剩下守护线程时，JVM 会自动退出。无论守护线程是否执行完毕
     */
    @Test
    public void threadDaemon() throws InterruptedException {
        log.info("主线程名: {}, 守护线程: {}", Thread.currentThread().getName(), Thread.currentThread().isDaemon());
        Thread thread = new Thread(() -> {
            ThreadUtils.sleep(3);
            log.info("子线程名: {}, 守护线程: {}", Thread.currentThread().getName(), Thread.currentThread().isDaemon());
        }, "thread-1");
        thread.setDaemon(true);
        thread.start();
        // thread.join();// 阻塞线程,直到子线程结束
        log.info("结束");
    }

    @Test
    public void testThreadInterruptedException() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("线程name: {}", Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.info("捕获异常, {}", e.getMessage());
            }
            log.info("线程name: {}", Thread.currentThread().getName());
        }, "testThread-1");
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("测试结束");
    }

    @Test
    public void testSelfStart() {
        Thread thread = new Thread(() -> {
            ThreadUtils.sleep(2);
            throw new RuntimeException("测试抛出异常");
        }, "testThread-1");
        thread.setUncaughtExceptionHandler((originThread, throwable) -> {
            ThreadUtils.sleep(1);
            log.info("发生异常: {}; 开始重启", throwable.getMessage());
            new TestThread().testSelfStart();
        });
        // 启动线程
        thread.start();
        Thread.currentThread().getThreadGroup().list();
        ThreadUtils.sleep(20);
        Thread.currentThread().getThreadGroup().list();
    }

    @Test
    public void testThreadLocal() throws InterruptedException {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "-1");
        int i = 1;
        threadLocal.set("789");
        Thread t1 = new Thread(() -> {
            log.info("i: " + i);
            threadLocal.set("t1");
            log.info("thread-1: " + threadLocal.get());
            threadLocal.remove();
            log.info("thread-1: " + threadLocal.get());
        },"thread-1");
        Thread t2 = new Thread(() -> {
            threadLocal.set("t2");
            log.info("thread-2: " + threadLocal.get());
            threadLocal.remove();
            log.info("thread-2: " + threadLocal.get());
        },"thread-2");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        log.info("main 线程: " + threadLocal.get());
    }
}
