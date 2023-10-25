package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2022/8/22
 * --
 * Java中的关于线程池的核心类是Executor，Executor是一个接口，真正的线程池的实现为ThreadPoolExecutor;线程池的优点在于：
 * ① 复用线程池中的线程，避免因为线程的创建和销毁所带来的性能开销。
 * ② 能够有效的控制线程池的最大并发数，避免大量的线程之间因互相抢占系统资源而导致的阻塞现象。
 * ③ 能够对线程进行简单的管理，并提供定时执行以及指定间隔循环执行等功能。
 * --
 *  ThreadPoolExecutor
 *      corePoolSize        线程数量
 *      maximumPoolSize     临时最大线程数量
 *      keepAliveTime       非核心线程闲置时的超时时长，超过这个时长，非核心线程就会被回收
 *      unit                keepAliveTime参数的时间单位
 *      workQueue           线程池中的任务队列，通过线程池execute方法提交的Runnable对象会存储在这个参数中。这个任务队列是BlockQueue类型，属于阻塞队列，就是当队列为空的时候，此时取出任务的操作会被阻塞，等待任务加入队列中不为空的时候，才能进行取出操作，而在满队列的时候，添加操作同样被阻塞
 *      threadFactory       线程工厂，为线程池提供创建新线程的功能。ThreadFactory是一个接口，它只有一个方法，newThread（Runnable r），用来创建线程
 *      RejectedExecutionHandler    饱和策略,当任务队列和线程池都满了时所采取的应对策略, 默认策略:AbordPolicy: 抛出RejectedExecutionExcepton异常
 *  常见线程池类型:
 *      FixedThreadPool         核心线程池数量和最大线程池数量一致,任务队列不受限(LinkedBlockingQueue); 场景: 任务小于最大线程数
 *      ScheduledThreadPool     非核心线程数任意大, 执行定时任务和具有固定周期的重复任务
 *      CachedThreadPool        没有核心线程,最大线程; 一旦有任务过来，会立刻开一个线程执行任务
 *      SingleThreadExecutor    有且只有一个核心线程, 任务队列不受限; 场景: 所有任务都控制在一个线程中，并按照一定顺序执行，这样就不用处理这些任务的同步问题
 *      --
 *      关键方法:
 *          execute 该方法给线程池提交一个将来要执行的任务。这个任务可能在一个新开的线程中执行，或者在一个已经在线程池中的线程执行。如果任务无法提交执行，无论是因为该执行程序已关闭或因其容量已达到，该任务将由当前的RejectedExecutionHandler处理。
 *          addWorker   检查是否可以根据当前池状态和给定的界限, 添加并创建新的Worker
 *  阻塞队列:
 *      ① 队列中没有数据时，消费者端会被自动阻塞（挂起），直到有数据放入队列，再被唤醒。
 *      ② 当队列中填满数据时，生产者端会被自动阻塞（挂起），直到队列中有空位置时，再被唤醒。
 *      关键方法:
 *          方法\处理方式	抛出异常	返回特殊值	一直阻塞	超时退出
 *          插入方法	add(e)	offer(e)	put(e)	offer(e,time,unit)
 *          移除方法	remove()	poll()	take()	poll(time,unit)
 *          检查方法	element()	peek()	不可用	不可用
 *          --
 *          抛出异常：是指当阻塞队列满时候，再往队列里插入元素，会抛出IllegalStateException(“Queue full”)异常。当队列为空时，从队列里获取元素时会抛出NoSuchElementException异常
 *          返回特殊值：插入方法会返回是否成功，成功则返回true。移除方法，则是从队列里拿出一个元素，如果没有则返回null
 *          一直阻塞 ：当阻塞队列满时，如果生产者线程往队列里put元素，队列会一直阻塞生产者线程，直到拿到数据，或者响应中断退出。当队列空时，消费者线程试图从队列里take元素，队列也会阻塞消费者线程，直到队列可用。
 *          超时退出：当阻塞队列满时，队列会阻塞生产者线程一段时间，如果超过一定的时间，生产者线程就会退出。
 *      ArrayBlockingQueue      一个用数组实现的有界阻塞队列。此队列按照先进先出（FIFO）的原则对元素进行排序。一旦指定了队列的长度，则队列的大小不能被改变。在生产者消费者例子中，如果生产者生产实体放入队列超过了队列的长度，则在offer(或者put,add)的时候会被阻塞，直到队列的实体数量小于队列的初始size为止。不过可以设置超时时间，超时后队列还未空出位置，则offer失败。如果消费者发现队列里没有可被消费的实体时也会被阻塞，直到有实体被生产出来放入队列位置，不过可以设置等待的超时时间，超过时间后会返回null。
 *      DelayQueue              一个使用优先级队列实现的无界阻塞队列。队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素。
 *      LinkedBlockingQueue     一个用链表实现的有界阻塞队列。可以通过构造方法设置capacity来使得阻塞队列是有界的，也可以不设置，则为无界队列。此队列按照先进先出的原则对元素进行排序。
 *      PriorityBlockingQueue   无界限队列，相当于PriorityQueue 和 BlockingQueue的结合体。插入的对象必须是可比较的，或者通过构造方法实现插入对象的比较器Comparator。队列里的元素按Comparator comparator比较结果排序
 *      SynchronousQueue        无内部容量的阻塞队列，put必须等待take，同样take必须等待put。比较适合两个线程间的数据传递。异步转同步的场景不太适用，因为对于异步线程来说在处理完事务后进行put，但是必须等待put的值被取走。SynchronousQueue的吞吐量高于LinkedBlockingQueue 和 ArrayBlockingQueue。
 */
@Slf4j
public class TestThreadPool {


    @Test
    public void test1() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        // fixedThreadPool.submit(task)
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() -> {
                log.info("线程id: {}", Thread.currentThread().getId());
                ThreadUtils.sleep(2);
            });
        }
        log.info("shutdown之前: {}, {}", fixedThreadPool.isShutdown(), fixedThreadPool.isTerminated());
        fixedThreadPool.shutdown();// 关闭线程,不能再提交任务,直到任务结束, 非阻塞, 主线程使用awaitTermination等待
        log.info("shutdown之后: {}, {}", fixedThreadPool.isShutdown(), fixedThreadPool.isTerminated());
        boolean res = fixedThreadPool.awaitTermination(10, TimeUnit.SECONDS); //awaitTermination 前调用 shutdown 改变状态
        log.info("awaitTermination: {}; ", res);
        log.info("执行完毕");
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        AtomicInteger i = new AtomicInteger();
        Callable<Integer> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(1000);
            return i.getAndIncrement();
        };

        ScheduledFuture<Integer> scheduledFuture = fixedThreadPool.schedule(callable, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduleAtFixedRateRes = fixedThreadPool.scheduleAtFixedRate(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);
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
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        Thread thread = new Thread(() -> {
            log.info("子线程:" + Thread.currentThread().getName());
            ThreadUtils.sleep(1);
            throw new RuntimeException("测试子线程异常");
        });
        // 日志打印失败
        thread.setUncaughtExceptionHandler((thread1, err) -> log.error("线程异常, 异常原因: ", err));
        fixedThreadPool.scheduleAtFixedRate(thread, 1, 1, TimeUnit.SECONDS);
        ThreadUtils.sleep(5);
    }

    @Test
    public void test34() throws InterruptedException, ExecutionException {
        AtomicInteger i = new AtomicInteger();
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        Callable<Integer> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return i.getAndIncrement();
        };

        ScheduledFuture<Integer> scheduledFuture = fixedThreadPool.schedule(callable, 1, TimeUnit.SECONDS);

        boolean res = fixedThreadPool.awaitTermination(30, TimeUnit.SECONDS);
        log.info("线程池执行完毕: {}", res);
        if (!res) {
            // fixedThreadPool.shutdown();
            List<Runnable> resList = fixedThreadPool.shutdownNow();
            for (Runnable runnable : resList) {
                log.info("r" + runnable);
            }
        }
        log.info("线程池执行完毕: {}", fixedThreadPool.isShutdown());
        Integer integer = scheduledFuture.get();
        log.info("结果: " + integer);
    }
}
