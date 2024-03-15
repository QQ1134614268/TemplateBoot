package com.it.sim.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zero DateTime 2018年5月30日 上午10:37:42
 */

public class TestLambda {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void eg1() {
        // 例1、用lambda表达式实现Runnable
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

        new Thread(() -> {
            System.out.println("子线程:" + Thread.currentThread().getName() + ":" + sdf.format(new Date()));
            try {
                Thread.sleep(1000);// 休息1s
            } catch (InterruptedException ignored) {
            }
            System.out.println("子线程:" + Thread.currentThread().getName() + ":" + sdf.format(new Date()));
        }).start();
    }

    @Test
    public void eg2() {
        // 例2 addActionListener 使用Java 8 lambda表达式进行事件处理
        // 我开始使用Java 8 时，首先做的就是使用lambda表达式替换匿名类，而实现Runnable接口是匿名类的最好示例。
        // Java 8之前：
        JButton show = new JButton("Show");
        show.addActionListener(e -> System.out.println("Event handling without lambda expression is boring"));

        // Java 8方式：
        show.addActionListener((e) -> System.out.println("Light, Camera, Action !! Lambda expressions Rocks"));

        // Java开发者经常使用匿名类的另一个地方是为 Collections.sort() 定制 Comparator

    }

    @Test
    public void eg3() {
        // 例3、使用lambda表达式对列表进行迭代
        // Java 8之后：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }

    @Test
    public void testFunctionToLambda() {
        // 模拟add(a,b)
        BiFunction<Integer, Long, String> biFunction = (a, b) -> String.valueOf(a + b);
        String res = biFunction.apply(1, 2L);
        System.out.println(res);
    }
}
