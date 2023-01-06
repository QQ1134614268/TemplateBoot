package com.it.sim.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked", "MismatchedQueryAndUpdateOfCollection"})
public class TestArrayList {

    // 1. List<String>:  声明变量类型 仅可以编译检查, 取数据会强制转换
    // 2. new ArrayList<>() :  <>默认未声明类型, 若没有为object, 若不一样编译错误
    // 3. 可以通过参数 推导<> 类型
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void main() {
        // List<Object> i3 = new ArrayList<String>();

        List<String> i5 = new ArrayList<>();
        i5.add("");
        // i5.add(6);
        List<String> i6 = new ArrayList();
        i6.add("");
        // i6.add(6);

        List i7 = new ArrayList();
        i7.add("");
        i7.add(6);

        List i8 = new ArrayList<Double>();
        i8.add(2);
        i8.add("2.3");
        System.out.println(i8.get(0));
        System.out.println(i8.get(1));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void b() {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        System.out.println(a.getClass() == b.getClass());// 输出发现c1==c2为true
        // ArrayList<String>和ArrayList<Integer>很容易认为是不同的类型， 不同的类型在行为方面肯定不同; 但输出发现c1==c2为true
    }

    /**
     * 擦除的问题 为什么要擦除： 1.5版本才出现泛型 为了兼容之前地代码 它使得泛化的客户端可以用非泛化的类库来使用。
     * 以及不破坏现有类库的情况下，将泛型融入java语言。 擦除使得现有的非泛型客户端代码能够在不改变的情况继续使用，直至客户端准备号用泛型重写这些代码。
     * 擦除的代价：泛型不能用于显示地引用运行时类型的操作值中，例如转型instanceof操作和new表达式。
     * 因为所有关于参数的类型都丢失了。无论何时，当你在编写泛型代码时，必须时刻提醒自己， 你只是看起来好像拥有关于参数的类型信息而已。提醒自己：T
     * 不，它值时一个Object 擦除使用泛型并不是强制的
     */
    @Test
    public void main2() {

        class Particle<T, E> {
        }
        Particle<Long, Double> part = new Particle<>();
        System.out.println(Arrays.toString(part.getClass().getTypeParameters())); //[T, E]
        // Class.getTypeParameters()将返回一个TypeVariable对象数组，表示有泛型声明
        // 的类型参数...
        /*
          输出结果是一些占位符 说明：在泛型代码内部，无法获得任何有关泛型参数类型的信息。
          当你在使用泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象。
          因此，List<String>和List<Integer>在运行时事实上是相同的类型。这两种形式都被 擦除成它们的原生类型，即List
         */
    }
}