package com.it.sim.design;

/**
 * 抽象算法的策略类，定义所有支持的算法的公共接口
 */
abstract class Strategy {
    /**
     * 算法方法
     */
    public abstract void AlgorithmInterface();
}

/**
 * 具体算法A
 */
class ConcreteStrategyA extends Strategy {
    // 算法A实现方法
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A的实现");
    }
}

/**
 * 具体算法B
 */
class ConcreteStrategyB extends Strategy {
    /**
     * 算法B实现方法
     */
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法B的实现");
    }
}

/**
 * 具体算法C
 */
class ConcreteStrategyC extends Strategy {
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法C的实现");
    }
}

/**
 * 上下文，维护一个对策略类对象的引用
 */
class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.AlgorithmInterface();
    }
}

/**
 * 客户端代码：实现不同的策略
 */
public class StrategyPattern {
    public static void main(String[] args) {

        Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}