package com.it.jiangxin.controller;

class Parent {
    public String color;

    public Parent() {
        this.color = "green";

    }//在这里删掉父类的printColor方法

    /**
     * public void printColor(){
     * <p>
     * // System.out.println(color);
     * <p>
     * }
     */

    public static void main(String args[]) {
        new Child().printColor();

    }

}

class Child extends Parent {//我们在这里删掉color属性//public String color;

    public Child() {

    }

    public void printColor() {

        System.out.println(color);

    }

}