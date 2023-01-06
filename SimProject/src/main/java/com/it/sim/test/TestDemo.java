package com.it.sim.test;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDemo {

    @Test
    public void test1() {
        // 交集
        List<String> aList = Collections.singletonList("A1");
        List<String> bList = Collections.singletonList("A1");
        List<String> tmp = new ArrayList<>(aList);
        tmp.removeAll(bList);
        tmp.forEach(System.out::println);
    }

    @Test
    public void testUnion() {
        // 并集
        List<String> aList = Collections.singletonList("A1");
        List<String> bList = Collections.singletonList("A1");
        List<String> tmp = new ArrayList<>(aList);
        tmp.addAll(bList);
        tmp.forEach(System.out::println);
    }

    @Test
    public void test() {
        // 自动转型
        short s1 = 1;
        // short s3 = s1 + 1;
        int s2 = s1 + 1;
        System.out.println(s2);
    }

    @Test
    public void test2() {
        short s1 = 1;
        System.out.println(s1);
        // 由于 +=是 java 语言规定的运算符，java 编译器会对它进行特殊处理，因此可以正确编译。
        s1 += 1;
        System.out.println(s1);
    }


    @Test
    public void test3() {
        char a = '中';
        System.out.println(a);
    }

    @Test
    public void test4() {
        byte a = -1;
        byte b = -1;
        // -1在内存中对应的二进制数据为11111111，
        int c = a + b;
        System.out.println(c);
    }

    @Test
    public void test5() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int sum = a + b;
        System.out.println(sum);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    public void test7() {
        // 使用 final 关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？
        final StringBuilder a = new StringBuilder("immutable");
        a.append(" broken!");
        System.out.println(a);
    }

    // 请说出作用域 public，private，protected，以及不写时的区别

    // Overload 和 Override 的区别。Overloaded 的方法是否可以改变返回值的类型?

    // 类,子类
    // 构造器不是方法，那么用来修饰方法特性的所有修饰符都不能用来修饰构造器（并不等与构造器具备这些特性，虽然不能用static修饰构造器，但它却有静态特性）构造器只能用 public private protected这三个权限修饰符，且不能有返回语句。

    // 、abstract 的 method 是否可同时是 static,是否可同时是 native，是否可同  时是 synchronized?
    @SuppressWarnings({"NewObjectEquality", "StringOperationCanBeSimplified", "StringEquality"})
    @Test
    public void test8() {
        // 下面这条语句一共创建了多少个对象：String s="a"+"b"+"c"+"d";
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        String s4 = "ab" ;
        String s5 = new String("ab") ;
        System.out.println(s2 == "ab");
        System.out.println(s3 == "ab");
        System.out.println(s4 == "ab");
        System.out.println(s5 == "ab");

    }

    @Test
    public void test10() {
        int x = 50, y;
        y = ++x + x++ + --x;
        System.out.println(y);
    }

    @Test
    public void test12() {
        // 用在方法体内，后面跟的是异常类对象名
        throw new ArithmeticException();
    }
}
