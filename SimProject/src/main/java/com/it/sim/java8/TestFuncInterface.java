package com.it.sim.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zero DateTime 2018年5月4日 下午2:38:38
 * @ :
 */
public class TestFuncInterface {

    //	写lambda表达式需要有函数式接口支持，单并不是说每次用lambda表达式时都要自定义一个函数式接口，实际上，Java8已经为我们准备了java.util.function包，
    //	其中有许多非常实用的函数式接口，大致可以分为4种，下面介绍4种核心的接口的典型代表。

    public static void main(String[] args) {

        //	1	消费型接口   消费型接口典型的代表为Consumer，其抽象方法为accept(), 该方法仅接受一个参数，并且没有返回值
        handle("Hello world!", System.out::println); // System.out::println
        handle("Hello world!", System.out::println);
        //	2	供给型接口    供给型接口的典型代表为Supplier，其抽象方法为get(), 该方法不接受参数，但有返回值
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer i : list) {
            System.out.println(i);
        }

        //  3	供给型接口	 函数型接口中的代表为Function，其抽象方法位apply(), 接受有一个参数，并且有返回值
        System.out.println(convert("100", Integer::parseInt));

        //  4	断言型接口   断言型接口的典型接口为Predicate，其抽象方法为test(), 接受一个参数
        List<Integer> list2 = Arrays.asList(1, 2, 3, 5, 7, 11, 20, 47);

        List<Integer> myList = filterInt(list2, (e) -> e > 3);
        for (Integer i : myList) {
            System.out.println(i);
        }
    }

    public static void handle(String s, Consumer<String> con) {
        con.accept(s);
    }

    // 产生指定个数的整数，并将其置于集合中
    public static List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    public static Integer convert(String str, Function<String, Integer> fun) {
        return fun.apply(str);
    }

    public static List<Integer> filterInt(List<Integer> list, Predicate<Integer> pre) {
        List<Integer> myList = new ArrayList<>();
        for (Integer i : list) {
            if (pre.test(i)) {
                myList.add(i);
            }
        }
        return myList;
    }
}
