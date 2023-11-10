package com.it.sim.test;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda stream Comparator todo
 */
public class TestComparator {
    public static void main(String[] args) {
        // create some Persons objects
        Persons p1 = new Persons("B", 10);
        Persons p2 = new Persons("D", 20);
        Persons p3 = new Persons("A", 18);

        // before sort
        List<Persons> list = Arrays.asList(p2, p1, p3);
        System.out.println("Before Sort:");
        list.forEach(Persons -> System.out.println("Persons name" + Persons.name));

        // 自定义比较器
        Comparator<Persons> byAge = Comparator.comparingInt((v) -> v.getAge());
        Collections.sort(list, byAge);
        System.out.println("After Sort:");
        list.forEach(Persons -> System.out.println("Persons age" + Persons.age));
    }
}


@Data
// 重写比较器
class Persons {
    String name;
    int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 定义此方法接受单个参数keyExtractor，该参数是用于提取整数排序键的函数。
    public Integer getAge() {
        return this.age;
    }


}
