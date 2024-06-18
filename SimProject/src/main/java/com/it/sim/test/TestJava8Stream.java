package com.it.sim.test;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zero DateTime 2018年5月30日 上午10:37:42
 */
public class TestJava8Stream {

    public static final List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 3);

    @Test
    public void testFilter() {
        Predicate<Integer> predicate = (num) -> num < 3;         // Predicate
        List<Integer> res = numbers.stream().filter(predicate).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(res));

        Predicate<Integer> predicate1 = (num) -> num >= 1; // // and 条件
        res = numbers.stream().filter(predicate.and(predicate1)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testMap() {
        List<Integer> res = numbers.stream().map(v -> v * 2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testReduce() {
        Integer res = numbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println(res);

        res = numbers.stream().reduce(0, Integer::sum);
        System.out.println(res);

        res = numbers.stream().parallel().reduce(0, Integer::sum, (x, y) -> 1); // 并行时, 各个结果怎么合并的函数
        System.out.println(res);
    }

    @Test
    public void testFlatMap() {
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

        List<Integer> res = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());// 将每个内部列表转换为Stream，并合并成一个Stream

        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testDistinct() {
        List<Integer> res = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testParallelStream() {
        Integer res = numbers.parallelStream().reduce(0, (x, y) -> {
            System.out.format("accumulator: x=%s; y=%s [%s]\n", x, y, Thread.currentThread().getName());
            return x + y;
        }, (x, y) -> {
            System.out.format("combiner: x=%s; y=%s [%s]\n", x, y, Thread.currentThread().getName());
            return x + y;
        });
        System.out.println(res);
    }

    @Test
    public void testSupplierStream() {
        Supplier<Stream<Integer>> supplier = () -> numbers.stream().filter(n -> n > 0);

        List<Integer> res = supplier.get().filter(s -> s > 1).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(res));
        boolean x = supplier.get().anyMatch(s -> s > 0); //  noneMatch
        System.out.println(x);

    }

    @Test
    public void testSummaryStatistics() {
        // IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics()
        // 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("IntSummaryStatistics : " + JSON.toJSONString(stats));
    }

    @Test
    public void testSelfDefineCollector() {
        Collector<String, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "), // supplier 供应器
                (j, p) -> j.add(p.toUpperCase()), // accumulator 累加器
                StringJoiner::merge, // combiner 组合器
                StringJoiner::toString); // finisher 终止器

        String names = numbers.stream().map(String::valueOf).collect(personNameCollector); // 传入自定义的收集器

        System.out.println(names); // MAX | PETER | PAMELA | DAVID
    }

    @Test
    public void testGroupBy() {
        Map<Integer, List<Integer>> res = numbers.stream()
                .collect(Collectors.groupingBy(v -> v)); // Function.identity()

        Map<Integer, Set<Integer>> res3 = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.toSet())));
        Map<Integer, Set<Integer>> res5 = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.mapping(Function.identity(), Collectors.toSet())));
        Map<Integer, List<Integer>> res4 = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<Integer, Integer> res6 = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(v -> v)));
        Map<Boolean, List<Integer>> res7 = numbers.stream().collect(Collectors.partitioningBy(s -> s > 50));
        // Collection<Integer> r = res6.values();

        Map<Integer, List<Integer>> res8 = numbers.stream().collect(Collectors.groupingBy(v -> {
            if (v == 1) {
                return 4;
            }
            if (v == 2) {
                return 5;
            }
            if (v == 3) {
                return 6;
            }
            return -1;
        }));
    }
}
