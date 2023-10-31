package com.it.sim.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * todo 并发包 concurrent 整理
 * <pre>
 * atomic包: 提供了一系列原子类; CAS，Compare and Swap即比较并交换。
 * locks包: 锁的一些扩展操作。synchronized和Lock API的使用: 如果说传统的synchronized是一个密码箱自带锁扣，那么lock就是为我们开发者提供的一把可以自由上锁的高级锁。
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
}
