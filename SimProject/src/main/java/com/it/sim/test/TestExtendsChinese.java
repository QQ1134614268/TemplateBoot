package com.it.sim.test;

class Person {
    public static void prt(String s) {
        System.out.println(s);
    }

    Person() {
        prt("父类·无参数构造方法： " + "A Person.");
    }// 构造方法(1)

    Person(String name) {
        prt("父类·含一个参数的构造方法： " + "A person's name is " + name);
    }// 构造方法(2)
}

@SuppressWarnings("ALL")
public class TestExtendsChinese extends Person {
    TestExtendsChinese() {
        super(); // 调用父类构造方法（1）
        prt("子类·调用父类”无参数构造方法“： " + "A chinese coder.");
    }

    TestExtendsChinese(String name) {
        super(name);// 调用父类具有相同形参的构造方法（2）
        prt("子类·调用父类”含一个参数的构造方法“： " + "his name is " + name);
    }

    TestExtendsChinese(String name, int age) {
        this(name);// 调用具有相同形参的构造方法（3）
        prt("子类：调用子类具有相同形参的构造方法：his age is " + age);
    }

    public static void main(String[] args) {
//		super（参数）：调用父类中的某一个构造函数（应该为构造函数中的第一条语句）。
//		this（参数）：调用本类中另一种形式的构造函数（应该为构造函数中的第一条语句）。

        @SuppressWarnings("unused")
        TestExtendsChinese cn = new TestExtendsChinese();
        cn = new TestExtendsChinese("codersai");
        cn = new TestExtendsChinese("codersai", 18);
    }
}