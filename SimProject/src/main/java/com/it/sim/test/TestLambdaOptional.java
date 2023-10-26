package com.it.sim.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author zero DateTime 2018年5月4日 下午2:23:38
 */

public class TestLambdaOptional {
    @SuppressWarnings({"ExcessiveLambdaUsage", "OptionalIsPresent"})
    @Test
    public void testOptional() {
        // Optional 支持lambda流式调用

        /* of */
        // 调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("YanWei");

        // 传入参数为null，抛出NullPointerException.
        // Optional<String> someNull = Optional.of(null);

        /* opNullable */
        Optional<String> empty = Optional.empty();

        /* isPresent */
        if (name.isPresent()) {
            System.out.println(name.get());// 输出YanWei
        }
        name.ifPresent(a -> System.err.println(name.get()));
        name.ifPresent(a -> System.err.println(a + "99"));
        /* get */
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }

        /* ifPresent */
        name.ifPresent((value) -> System.out.println("The length of the value is: " + value.length()));

        /* orElse */
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        /* orElseGet */
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(String::new));

        /* orElseThrow */
        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable ex) {
            System.out.println("error:" + ex.getMessage());
        }

    }
    @Test
    public void testOptionalLambda() {
        // Optional 支持lambda流式调用

        Optional<String> name = Optional.of("YanWei");
        /* map */
        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println(upperName.orElse("No value found"));

        /* flatMap */
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.get());

        /* filter */
        List<String> names = Arrays.asList("123456", "123456789");
        for (String s : names) {
            Optional<String> nameLenLessThan7 = Optional.of(s).filter((value) -> value.length() < 7);
            System.out.println(nameLenLessThan7.orElse("The name is more than 6 characters"));
        }

    }
}
