package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * 线程池优点:
 *      1. 复用, 避免创建和销毁的性能开销
 *      2. 可以设置最大并发数等, 管理线程
 *      3. 支持定时, 循环执行等功能
 * ThreadPoolExecutor      理解 Executor 执行 + ThreadPool
 *      corePoolSize        线程数量
 *      maximumPoolSize     临时最大线程数量, 不用的会销毁
 *      keepAliveTime       非核心线程闲置时的超时时长，超过这个时长，非核心线程就会被回收
 *      unit                keepAliveTime参数的时间单位
 *      workQueue           线程池中的任务队列，保存提交的task
 *      threadFactory       线程工厂，创建新线程
 *      RejectedExecutionHandler    饱和策略,当任务队列和线程池都满了时所采取的应对策略
 * RejectedExecutionHandler:
 *      AbortPolicy     默认; 抛出RejectedExecutionException异常
 *      DiscardPolicy
 *      CallerRunsPolicy
 *      DiscardOldestPolicy
 *  常见线程池类型:
 *      FixedThreadPool         核心线程池数量和最大线程池数量一致,任务队列不受限(LinkedBlockingQueue); 场景: 任务小于最大线程数
 *      ScheduledThreadPool     非核心线程数任意大, 执行定时任务和具有固定周期的重复任务
 *      CachedThreadPool        没有核心线程,最大线程; 一旦有任务过来，会立刻开一个线程执行任务
 *      SingleThreadExecutor    有且只有一个核心线程, 任务队列不受限; 场景: 所有任务都控制在一个线程中，并按照一定顺序执行，这样就不用处理这些任务的同步问题
 * workQueue: 没有数据时, 获取阻塞; 满数据时,添加阻塞
 *         ArrayBlockingQueue      一个用数组实现的有界阻塞队列。此队列按照先进先出（FIFO）的原则对元素进行排序。一旦指定了队列的长度，则队列的大小不能被改变。在生产者消费者例子中，如果生产者生产实体放入队列超过了队列的长度，则在offer(或者put,add)的时候会被阻塞，直到队列的实体数量小于队列的初始size为止。不过可以设置超时时间，超时后队列还未空出位置，则offer失败。如果消费者发现队列里没有可被消费的实体时也会被阻塞，直到有实体被生产出来放入队列位置，不过可以设置等待的超时时间，超过时间后会返回null。
 *         DelayQueue              一个使用优先级队列实现的无界阻塞队列。队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素。
 *         LinkedBlockingQueue     一个用链表实现的有界阻塞队列。可以通过构造方法设置capacity来使得阻塞队列是有界的，也可以不设置，则为无界队列。此队列按照先进先出的原则对元素进行排序。
 *         PriorityBlockingQueue   无界限队列，相当于PriorityQueue 和 BlockingQueue的结合体。插入的对象必须是可比较的，或者通过构造方法实现插入对象的比较器Comparator。队列里的元素按Comparator comparator比较结果排序
 *         SynchronousQueue        无内部容量的阻塞队列，put必须等待take，同样take必须等待put。比较适合两个线程间的数据传递。异步转同步的场景不太适用，因为对于异步线程来说在处理完事务后进行put，但是必须等待put的值被取走。SynchronousQueue的吞吐量高于LinkedBlockingQueue 和 ArrayBlockingQueue。
 * workQueue关键方法:
 *      add     插入; 抛出异常(满时插入，会抛出IllegalStateException异常。)
 *      offer   插入; 返回特殊值;插入方法会返回是否成功，成功则返回true
 *      put	    插入; 一直阻塞; 满时阻塞生产者线程
 *      offer   插入; 超时退出(当阻塞队列满时，队列会阻塞生产者线程一段时间，如果超过一定的时间，生产者线程就会退出)
 *      remove  空时获取,会抛出NoSuchElementException异常
 *      poll	从队列里拿出一个元素，没有则返回null
 *      take	一直阻塞; 空时，消费者线程试图从队列里take元素，队列也会阻塞消费者线程，直到队列可用。
 *      poll    超时退出
 *      peek    返回特殊值
 *      element 检查方法; 抛出异常
 * </pre>
 */
@Slf4j
public class TestThreadPool {
    /**
     * execute(Runnable)
     * submit(Runnable)
     * submit(Callable)
     */
    @Test
    public void testThreadPool() throws Exception {
        // int corePoolSize = 2;
        // int maximumPoolSize = 2;
        // int keepAliveTime = 60;
        // TimeUnit timeUnit = TimeUnit.SECONDS;
        // ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        // ThreadPoolExecutor.DiscardPolicy handler = new ThreadPoolExecutor.DiscardPolicy();
        // // 手动构建
        // ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue, handler);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Callable<Integer> callable = () -> {
            log.info("开始执行");
            ThreadUtils.sleep(3);
            return 0;
        };
        fixedThreadPool.submit(callable);
        log.info("{}", callable.call()); // 获取结果
    }

    /**
     * schedule
     * scheduleAtFixedRate
     */
    @Test
    public void testScheduledThreadPool() throws InterruptedException, ExecutionException {
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        AtomicInteger i = new AtomicInteger();
        Callable<Integer> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(1000);
            return i.getAndIncrement();
        };

        ScheduledFuture<Integer> scheduledFuture = fixedThreadPool.schedule(callable, 1, TimeUnit.SECONDS);
        // ScheduledFuture<?> scheduleAtFixedRateRes = fixedThreadPool.scheduleAtFixedRate(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);
        fixedThreadPool.scheduleWithFixedDelay(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);

        boolean res = fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);

        log.info("res: {}", scheduledFuture.get());
        // scheduleAtFixedRateRes.get()// 阻塞
        // log.info("scheduleAtFixedRate: {}", scheduleAtFixedRateRes.get());

        log.info("线程池执行完毕: {}", res);
    }


    public static void info() {
        ThreadUtils.sleep(1);
        log.info(Thread.currentThread().getName());
    }


    @Test
    public void testThreadPoolException() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Thread thread = new Thread(() -> {
            log.info("子线程:" + Thread.currentThread().getName());
            ThreadUtils.sleep(1);
            throw new RuntimeException("测试子线程异常");
        });
        // 日志打印失败
        thread.setUncaughtExceptionHandler((thread1, err) -> log.error("线程异常, 异常原因: ", err));
        fixedThreadPool.execute(thread);
        ThreadUtils.sleep(5);
    }

    /**
     * shutdown: 关闭线程池，不再接受新任务，但会执行完已提交的任务
     * shutdownNow: 立刻强制结束
     * awaitTermination: 阻塞, 直到任务执行完(需要先调用 shutdown) | 超时, 执行完返回 true; 超时返回false;
     * isTerminated: 是否被终止
     */
    @Test
    public void testAwaitTermination() throws InterruptedException {
        List<HashMap<String, String>> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10); // 创建一个固定大小的线程池

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    HashMap<String, String> e = new HashMap<>();
                    list.add(e); // ArrayList在多线程下,add会缺失,或会添加null;
                    // 解决办法: 1. synchronized; 2.CopyOnWriteArrayList; 3. Collections.synchronizedList; 4. Vector
                    // synchronized (list){
                    // }
                }
                ThreadUtils.sleep(5); // 模拟任务执行时间
                return finalI;
            });
        }
        executor.shutdown();
        log.info("size total: {}; null个数: {}", list.size(), list.stream().filter(Objects::isNull).count());
        boolean flg = executor.awaitTermination(4, TimeUnit.SECONDS); // 4秒后超时
        log.info("awaitTermination 执行完毕: {}, {}", flg, executor.isTerminated());
        // ThreadUtils.sleep(20);
        boolean flg2 = executor.awaitTermination(10, TimeUnit.SECONDS); // 执行结束
        log.info("awaitTermination2 执行完毕: {}, {}", flg2, executor.isTerminated());
        log.info("size2 total: {}; null个数: {}", list.size(), list.stream().filter(Objects::isNull).count());

        if (!flg2) {
            executor.shutdownNow();// 强制退出
        }
    }
}
