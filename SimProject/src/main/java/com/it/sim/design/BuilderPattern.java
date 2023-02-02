package com.it.sim.design;

import java.util.ArrayList;
import java.util.List;

class Computer {

    /**
     * 电脑组件集合
     */
    private final List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }

    public void print() {
        for (String part : parts) {
            System.out.println("组件:" + part + "装好了...");
        }
        System.out.println("电脑组装完毕...");
    }
}

abstract class Builder {
    /**
     * 第一步：装CPU
     */
    public abstract void buildCPU();

    /**
     * 第二步：装主板
     */
    public abstract void buildMainBoard();

    /**
     * 第三步：装硬盘
     */
    public abstract void buildHD();

    /**
     * 获得组装好的电脑
     *
     */
    public abstract Computer getComputer();
}

/**
 * 装机人员装机
 */
class Director {
    public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}

/**
 * 具体的装机人员
 */
class ConcreteBuilder extends Builder {

    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.Add("装CPU");
    }

    @Override
    public void buildMainBoard() {
        computer.Add("装主板");
    }

    @Override
    public void buildHD() {
        computer.Add("装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}


public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.Construct(builder);
        Computer computer = builder.getComputer();
        computer.print();
    }
}