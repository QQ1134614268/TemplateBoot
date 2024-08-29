package com.it.sim.thread;

import com.it.sim.config.TimeConf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

/**
 * todo 并发包 concurrent 整理
 * <pre>
 * synchronized和Lock对比: 如果说传统的synchronized是一个密码箱自带锁扣，那么lock就是为我们开发者提供的一把可以自由上锁的高级锁。
 * --
 * atomic包: 提供了一系列原子类; CAS，Compare and Swap即比较并交换。
 * locks包: 锁的一些扩展操作。
 *      ReentrantLock: 可重入锁
 *      Condition 接口: Condition接口一般与Lock配合使用，拥有一系列的await、signal方法。Lock+Condition的wait/signal相当于sync+wait/notify。
 *      ReentrantReadWriteLock: 可重入读写锁; 优化了的共享&排它锁，它允许多个线程同时读取共享数据，但又只允许一次只有一个线程对共享数据进行更新。从读取测提升了一定的效率。使用时只产生一个读写锁对象，但是可以取得两个不同的角色（读/写）锁进行读写上锁。
 *      LockSupport: LockSupport作为另一种并发工具，为我们带来了新的更简洁的方式控制线程的等待、唤醒。
 * CountDownLatch: 门闩锁; 本质上是个减法计数器，他可以使一个或多个线程等待一组其他线程完成后在执行。（想让一组线程全部执行完，再接着执行下面的步骤）
 * CyclicBarrier: 栅栏锁; 本质上是一个加法计数器，他可以让一组线程相互等待直到最后一个线程完成后，在进行下一步操作。（想让一组线程在每次都一起完成，再开始下一布）
 * Semaphore: 共享锁; 本质上是一个计数信号量，每个线程可以向他获取acquire()、释放release()许可，获得许可的线程得以继续执行，信号量全部获取完时，其他线程将阻塞。
 * -- 线程安全
 * CopyOnWriteArrayList: 他相当于线程安全的ArrayList，使用方式和ArrayList保持一致。
 * CopyOnWriteArraySet:
 * CurrentHashMap:
 * -- 线程功能增强
 * Callable接口
 * FutureTask类
 * ThreadPoolExecutor 方式使用线程池
 * CompletionService: 一组任务管理接口; submit() - 提交任务;take() - 获取任务结果;poll() - 获取任务结果; 实现类: ExecutorCompletionService
 * --
 * transient:
 * volatile:
 * threadLocal:
 * </pre>
 */
@Slf4j
public class TestConcurrent {
    //
    AtomicInteger atomicInteger;
    //
    ReentrantLock reentrantLock;
    ReentrantReadWriteLock reentrantReadWriteLock;
    StampedLock stampedLock;
    //
    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;
    ConcurrentHashMap<String, Integer> concurrentHashMap;
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
    //
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    CyclicBarrier cyclicBarrier;
    //
    FutureTask<Integer> futureTask;
    ForkJoinPool forkJoinPool;
    Executors executors;
    ExecutorCompletionService<Integer> executorCompletionService;
    //
    ThreadLocal<Integer> threadLocal;

    /**
     * 测试ConcurrentHashMap 线程不安全此场景
     */
    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMap<String, SimpleDateFormat> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(TimeConf.YMD_HMS, new SimpleDateFormat(TimeConf.YMD_HMS));
        concurrentHashMap.put(TimeConf.HMS, new SimpleDateFormat(TimeConf.HMS));

        ThreadPoolExecutor poolHandel = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.DiscardPolicy());
        LocalDateTime end = LocalDateTime.now().plusSeconds(10);
        while (LocalDateTime.now().isBefore(end)) {
            poolHandel.execute(() -> {
                try {
                    SimpleDateFormat format = concurrentHashMap.get(TimeConf.YMD_HMS);
                    format.parse("2023-10-10 10:10:10"); // bug
                    // // 加锁, 避免异常
                    // synchronized (format) {
                    //     format.parse("2023-10-10 10:10:10");
                    // }
                    // System.out.println(concurrentHashMap.get(TimeConf.YMD_HMS).parse("2023-10-10 10:10:10"));
                } catch (Throwable e) {
                    log.error("异常", e);
                }
            });
        }
    }

    /**
     * 创建 100 个线程，每个线程添加 1000 个元素
     * <br>
     * 方法1. 使用线程池: 避免同时创建线程太多,资源不够; 避免线程太多,没有资源;
     * 方法2: 并行流并发处理任务: 线程多,资源不够;线程少不能充分利用
     */
    @Test
    public void testBatch() throws InterruptedException {
        // List<Integer> list = new ArrayList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建10个线程的线程池
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    // 多线程下: ArrayList 线程不安全, add会缺失数据, null; 可以使用 synchronized
                    // CopyOnWriteArrayList 线程安全 不会丢失数据
                    list.add(j);
                    // 方法二:
                    // synchronized (list){
                    //     list.add(j);
                    // }
                }
            });
        }
        executorService.shutdown(); // 关闭线程池
        boolean endFlag = executorService.awaitTermination(10, TimeUnit.SECONDS);// 关闭线程池后,等所有任务执行完;
        log.info("size: {}, {}, {} ", endFlag, list.size(), list.stream().filter(Objects::isNull).count());

        // 方法二:
        List<Integer> list2 = new CopyOnWriteArrayList<>();
        // List<Integer> list2 = new ArrayList<>(); // 报错
        IntStream.range(0, 100).parallel().forEach((v) -> {
            for (int i = 0; i < 1000; i++) {
                list2.add(i);
            }
        });
        log.info("size2: {}", list2.size());
    }

    /**
     * <pre>
     * 对比ConcurrentHashMap HashMap HashTable:
     * HashTable: 方法上加锁;
     * ConcurrentHashMap: 类似HashTable, 锁的维度更细
     *
     * 类锁, 类方法锁, 对象方法锁, 对象锁
     * 类锁: 所有实例化对象共用一把锁，称之为类锁; 类锁只是一个概念上的东西，并不是真实存在的，它只是用来帮助我们理解锁定实例方法和静态方法的区别的
     * 对象锁: 修饰在方法上时，多个线程调用同一对象的同步方法时会阻塞，调用不同对象的同步方法时不会阻塞。
     * </pre>
     * 锁: 执行一个方法时, 里面会依赖很多变量, 多线程时,计算结果变得随机; 加上锁, 就保证结果不变;
     */
    @Test
    public void testThreadPoolExecutor2() {
        HashMap hashMap;
        Hashtable hashtable;
        ConcurrentHashMap concurrentHashMap1;
    }
}
