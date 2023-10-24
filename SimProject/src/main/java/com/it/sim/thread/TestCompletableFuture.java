package com.it.sim.thread;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @date 2022-10-11 17:17
 */
public class TestCompletableFuture {
    // FutureTask
    //      缺点：
    //          1. get()阻塞，一旦调用get()方法求结果，如果计算没有完成很容易导致程序阻塞。
    //          2. isDone()轮询：轮询的方式会耗费无谓的CPU资源，而且也不见得能及时地得到计算结果。如果想要异步获取结果，通常都会以轮询地方式去获取结果尽量不要阻塞。
    //      总结：Future对于结果地获取不是很友好，只能通过阻塞或轮询地方式获取结果

    // CompletableFuture
    //      1、在Java8中，CompletableFuture提供了非常强大的Future的扩展功能，可以帮助我们简化异步编程的复杂性，并且提供了函数式编程的能力，可以通过回调的方式处理计算结果，也提供了转换和组合CompletableFuture的方法。
    //      2、它可能代表一个明确完成的Future，也可能代表一个完成阶段(CompletionStage),它支持在计算完成以后触发一些函数和执行某些动作。
    //      3、它实现了Future和CompletionStage接口。

    // CompletionStage 代表异步计算过程中的某一个阶段，一个阶段完成后可能会触发另外一个阶段，有些类似Linux系统的管道分割符传递参数。
    // 一个阶段的计算执行可以是一个Future，Consumer，或者Runnable。
    // 一个阶段的执行可能是被单个阶段的完成触发，也可能是由多个阶段一起触发。
    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        // runAsync无返回值：
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(completableFuture.get());
    }

    @Test
    public void testRunAsync2() throws ExecutionException, InterruptedException {
        // runAsync无返回值：
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, pool);
        System.out.println(completableFuture.get());
        pool.shutdown();
    }

    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        //  supplyAsync有返回值：
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future ok";
        });
        System.out.println(completableFuture.get());
    }

    @Test
    public void testSupplyAsync2() throws ExecutionException, InterruptedException {
        //  supplyAsync有返回值：
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future ok";
        }, pool);
        System.out.println(completableFuture.get());
        pool.shutdown();
    }

    @Test
    public void testDemo1() {
        // 4.4、减少阻塞和轮询
        // 优点：1、异步任务结束时，会自动回调某个对象的方法。
        // 2、主线程设置好回调后，不再关心异步任务的执行，异步任务之间可以顺序执行。
        // 3、异步任务出错时，会自动回调某个对象的方法。
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName());
                int result = ThreadLocalRandom.current().nextInt(20);
                if (result > 5) {
                    throw new RuntimeException("测试一场");
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("计算结果需要1秒" + result);
                return result;
            }, pool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("----计算完成的值为：" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况：" + e.getCause() + "\t" + e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName() + "先去执行别的任务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        //主线程不要立刻结束，不然CompletableFuture使用的线程池会立刻关闭掉，这里可先暂停3秒
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDemo2() {
        // 4.5、使用CompletableFuture完成电商大比价
        @Data
        class NetMall {
            private String netMallName;

            public NetMall(String netMallName) {
                this.netMallName = netMallName;
            }

            public double calcPrice(String productName) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
            }
        }
        class CompletableFutureMall {
            public final List<NetMall> list = Arrays.asList(new NetMall("TaoBao"), new NetMall("jd"), new NetMall("DangDang"));

            //一家家搜索
            public List<String> getPrice(List<NetMall> list, String productName) {
                return list.stream()
                           .map(netMall -> String.format(" %s in %s price is %.2f", productName, netMall.getNetMallName(), netMall.calcPrice(productName)))
                           .collect(Collectors.toList());
            }

            //异步搜索
            public List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
                return list.stream()
                           .map(netMall -> CompletableFuture.supplyAsync(() -> String.format(" %s in %s price is %.2f", productName, netMall.getNetMallName(), netMall.calcPrice(productName))))
                           .collect(Collectors.toList()) // 取消后效率相当于同步？？
                           .stream()
                           .map(CompletableFuture::join)
                           .collect(Collectors.toList());
            }
        }

        CompletableFutureMall m = new CompletableFutureMall();
        long start = System.currentTimeMillis();
        List<String> stringList = m.getPrice(m.list, "java");
        for (String element : stringList) {
            System.out.println(element);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "毫秒");

        System.out.println("改进后的方法:");
        long start1 = System.currentTimeMillis();
        List<String> strings = m.getPriceByCompletableFuture(m.list, "java");
        for (String element : strings) {
            System.out.println(element);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("耗时:" + (end1 - start1) + "毫秒");

    }


    @Test
    public void testApi1() {
        // 获取结果
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "计算完成";
        });
        // System.out.println(completableFuture.get());// 调用就必须给值, 阻塞
        // System.out.println(completableFuture.get(0, TimeUnit.SECONDS));//调用后，只获得等待时间内的值
        // System.out.println(completableFuture.join());//与get方法一样
        System.out.println(completableFuture.getNow("替代值111"));// 立即获取结果不阻塞，计算完，返回计算完的值，否则就返回替代值
    }

    @Test
    public void testApi2() {
        // 5.2、主动触发计算
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "计算完成";
        });
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //当调用completableFuture.join()被阻塞时，complete方法返回true，并将里面的值赋给join方法并返回
        System.out.println(completableFuture.complete("123") + "\t" + completableFuture.join());
    }

    @Test
    public void testApi3() {
        // 5.3、对计算结果进行处理
        // 策略1
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        }, pool).thenApply(f -> {
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果:" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        // 策略2. 由于存在依赖关系，当前步骤有异常的话就叫停。
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        }, pool).handle((f, e) -> {
            System.out.println("222");
            if (Objects.equals(f, 1)) {
                throw new RuntimeException("测试一场");
            }
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果:" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        pool.shutdown();
    }

    @Test
    public void testApi4() throws InterruptedException {
        //5.4、对计算结果进行消费
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(System.out::println).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(System.out::println).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());
        // 2.
        ExecutorService pool = Executors.newFixedThreadPool(6);
        try {
            CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1号任务\t" + Thread.currentThread().getName());
                return "aa";
            }, pool).thenRunAsync(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2号任务\t" + Thread.currentThread().getName());
            }).thenRun(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3号任务\t" + Thread.currentThread().getName());
            }).thenRun(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4号任务\t" + Thread.currentThread().getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testApi5() {
        // 5.5、对计算速度进行选用
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "A完成了";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B完成了";
        });
        CompletableFuture<String> completableFuture = futureA.applyToEither(futureB, f -> f + "领先");
        System.out.println(Thread.currentThread().getName() + "\t" + completableFuture.join());
    }

    @Test
    public void testApi6() {
        // 5.6、对计算结果合并
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        CompletableFuture<Integer> result = future1.thenCombine(future2, (x, y) -> {
            System.out.println("两个结果开始合并");
            return x + y;
        });
        System.out.println(result.join());
    }
}