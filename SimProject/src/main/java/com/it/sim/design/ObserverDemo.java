package com.it.sim.design;

import java.util.ArrayList;
import java.util.List;

class Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

abstract class Observer {
    protected Subject subject;

    public abstract void update();
}

class ObserverImpl1 extends Observer {

    public ObserverImpl1(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("ObserverImpl1 String: " + Integer.toBinaryString(subject.getState()));
    }
}

class ObserverImpl2 extends Observer {

    public ObserverImpl2(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("ObserverImpl2 String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

class ObserverImpl3 extends Observer {

    public ObserverImpl3(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("ObserverImpl3 String: " + Integer.toOctalString(subject.getState()));
    }
}


public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new ObserverImpl1(subject);
        new ObserverImpl2(subject);
        new ObserverImpl3(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}