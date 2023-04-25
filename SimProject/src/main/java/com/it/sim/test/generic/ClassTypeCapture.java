package com.it.sim.test.generic;

/**
 * 擦除带来的问题 1.无法创建类型实例 2.无法使用 instanceof 3.无法调用类型实例方法
 * 解决办法
 * 通过引入类型标签来对擦除进行补偿。这意味着你需要显示地传递你地类型地Class对象， 以便你可以在类型表达式中使用它。 可以使用？extends T
 * 继承来实现可以调用方法
 */
class Erased<T> {
    public static void f(Object arg) {
        // if(arg instanceof T){}//Error无法使用instanceof
        // T var = new T();//Error无法创建类型实例
    }
}

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;
    T t;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
        try {
            t = kind.newInstance();// 创建类型实例
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public boolean isInstance(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> c1 = new ClassTypeCapture<>(Building.class);
        ClassTypeCapture<House> c2 = new ClassTypeCapture<>(House.class);
        System.out.println(c1.isInstance(c2));
        System.out.println(c1.isInstance(new Building()));
        System.out.println(c1.isInstance(new House()));
        System.out.println(c2.isInstance(new Building()));
        System.out.println(c2.isInstance(new House()));
    }

}
