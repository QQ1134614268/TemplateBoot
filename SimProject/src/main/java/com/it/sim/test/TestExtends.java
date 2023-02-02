package com.it.sim.test;

@SuppressWarnings("FieldCanBeLocal")
class Parent {
    public String name1 = "Parent_name1";
    private String name2 = "Parent_name2";

    public String getPublic() {
        return name1;
    }

    private String getPrivate() {
        return name2;
    }

    public void run() {
        System.out.println(getPublic());
        System.out.println(getPrivate());
    }
}
@SuppressWarnings("FieldCanBeLocal")
public class TestExtends extends Parent {
    public String name1 = "Child2_name1";
    private String name2 = "Child2_name2";

    public String getPublic() {
        return name1;
    }

    public String getPrivate() {
        return name2;
    }

    public static void main(String[] args) {
        // 1. 子类重写父类方法的前提是父类中的方法可以访问。
        // 声明为private的方法不能在类以外被访问，所以类B并非重写了类A 的m1方法，
        // 而正确的关系是类A和类B中的m1方法是两个毫无关联的不同方法；
        //
        // 2. 按照Java动态绑定的规则，a的声明类型是A，实际类型是B，调用方法时应该优先调用实际类型中重写的方法，
        //    但动态绑定的前提是方法被继承，此题中方法没有被继承，所以编译时调用声明类型A中的m1方法
        new TestExtends().run();
    }
}
