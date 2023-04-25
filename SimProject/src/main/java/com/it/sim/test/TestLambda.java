package com.it.sim.test;

import org.junit.Test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zero DateTime 2018年5月30日 上午10:37:42
 * @ :
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
    public void eg4() {
        // 例4、使用lambda表达式和函数式接口Predicate
        // 除了在语言层面支持函数式编程风格，Java 8 也添加了一个包，
        // 叫做 java.util.function。它包含了很多类，用来支持Java的函数式编程。其中一个便是Predicate，
        // 使用 java.util.function.Predicate
        // 函数式接口以及lambda表达式，可以向API方法添加逻辑，用更少的代码支持更多的动态行为。下面是Java 8
        // Predicate 的例子，展示了过滤集合数据的多种常用方法。Predicate接口非常适用于做过滤。

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        // ======================================
        System.out.println("Languages which starts with J :");
        filter2(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter2(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter2(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter2(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter2(languages, (str) -> str.length() > 4);

    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    // 更好的办法
    public static void filter2(List<String> names, Predicate<String> condition) {
        names.stream().filter(condition).forEach((name) -> System.out.println(name + " "));
    }

    @Test
    public void eg5() {

        // 例5、如何在lambda表达式中加入Predicate
        // 上个例子说到，java.util.function.Predicate 允许将两个或更多的
        // Predicate 合成一个。它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()，用于将传入 filter()
        // 方法的条件合并起来。例如，要得到所有以J开始，长度为四个字母的语言，可以定义两个独立的 Predicate 示例分别表示每一个条件，然后用
        // Predicate.and() 方法将它们合并起来，如下所示：

        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        List<String> names = Arrays.asList("tom", "kit", "jk");
        names.stream().filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }

    @Test
    public void eg6() {
        // 例6、Java 8 中使用lambda表达式的Map和Reduce示例
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }
        // 例6.2、Java 8 中使用lambda表达式的Map和Reduce示例
        // 为每个订单加上12%的税
        // 老方法：
        List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax1) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // 新方法：
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax2.stream().map((cost) -> cost + .12 * cost).reduce(Double::sum).get();
        System.out.println("Total : " + bill);
    }

    @Test
    public void eg7() {
        // 例7、通过过滤创建一个String列表
        // 过滤是Java开发者在大规模集合上的一个常用操作，而现在使用lambda表达式和流API过滤大规模数据集合是惊人的简单。流提供了一个 filter()
        // 方法，接受一个 Predicate 对象，即可以传入一个lambda表达式作为过滤逻辑。下面的例子是用lambda表达式过滤Java集合，将帮助理解。
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> strList = Arrays.asList("tom", "kit");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

    }

    @Test
    public void eg8() {
        // 例8、对列表的每个元素应用函数
        // 我们通常需要对列表的每个元素使用某个函数，例如逐一乘以某个数、除以某个数或者做其它操作。这些操作都很适合用 map()
        // 方法，可以将转换逻辑以lambda表达式的形式放在 map() 方法里，就可以对集合的各个元素进行转换了，如下所示。
        // 将字符串换成大写并用逗号链接起来

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

    }

    @Test
    public void eg9() {
        // 例9、复制不同的值，创建一个子列表
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

    }

    @Test
    public void eg10() {

        // 例10、计算集合元素的最大值、最小值、总和以及平均值
        // IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics()
        // 。可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic
        // s，描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum()
        //
        // 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
        // 获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

}
