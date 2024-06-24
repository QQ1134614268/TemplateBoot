package com.it.sim.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TestLambdaComparator {
    @Test
    public void eg1() {
        User p1 = new User("B", 1);
        User p2 = new User("D", 3);
        User p3 = new User("A", 2);
        List<User> users = Arrays.asList(p2, p1, p3);
        // 自定义比较器
        Comparator<User> byAge = Comparator.comparingInt(User::getAge);
        List<User> res = users.stream()
                .filter(v -> v != null && v.getAge() != null)
                .sorted(byAge)
                .collect(Collectors.toList());
        res.forEach(System.out::println);
    }

    @Test
    public void testCompareNull() {
        User p1 = new User("B", 1);
        User p2 = new User("D", null);
        User p3 = new User("A", 2);
        List<User> users = Arrays.asList(p2, p1, p3, null);
        // 自定义比较器
        Comparator<User> comparator = Comparator.comparing(User::getAge, Comparator.nullsFirst(Integer::compareTo))
                .reversed(); // nullsFirst 优先级高,  允许age 为空
        Comparator<User> c = Comparator.nullsFirst(comparator);// 允许user为空
        List<User> res = users.stream().sorted(c).collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}

@AllArgsConstructor
@Data
class User {
    String name;
    Integer age;
}


