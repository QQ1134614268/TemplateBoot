package com.it.sim.generic;

@SuppressWarnings({"UnnecessaryBoxing", "unused"})
public class TestStaticFans {
    // 静态函数
    public static <T> T StaticMethod(T a) {
        System.out.println("StaticMethod: " + a.toString());
        return a;
    }

    // 普通函数
    public <T> T OtherMethod(T a) {
        System.out.println("OtherMethod: " + a.toString());
        return a;
    }

    @SuppressWarnings("RedundantTypeArguments")
    public static void main(String[] args) {
        // 静态方法
        String a = TestStaticFans.StaticMethod("123");// 使用方法一
        String b = TestStaticFans.<String>StaticMethod("123");// 使用方法二

        // String c = StaticFans.StaticMethod(123);
        Object g = TestStaticFans.StaticMethod(123);
        TestStaticFans.StaticMethod(123);
        TestStaticFans.StaticMethod("123");
        // StaticFans.<String>StaticMethod(123);

        // 常规方法
        TestStaticFans testStaticFans = new TestStaticFans();
        Integer d = testStaticFans.OtherMethod(new Integer(123));// 使用方法一
        Integer e = testStaticFans.<Integer>OtherMethod(new Integer(123));// 使用方法二
    }
}