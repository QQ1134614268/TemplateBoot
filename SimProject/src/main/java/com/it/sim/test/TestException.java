package com.it.sim.test;

@SuppressWarnings("ALL")
public class TestException {
    public static void main(String[] args) {
        double d = 0.3;  //  作用于主方法全局的变量
        try {        //外层的异常处理
            if (d > 0.5)
                System.out.println(d);
            else    //自主定义的异常
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("369");
                }
        } catch (Exception el) {    //捕捉异常
            System.out.println("Exception catched by outer.");
            try {   //进一步处理由处理异常的语句产生的异常
                d = 10d / 0;    //算数异常
            } catch (ArithmeticException a) {    //捕捉算数异常
                System.out.println("ArithmeticException");
            } finally {
                System.out.println("inner block");
            }
        } finally {
              // String[] a =new String[3];
            // testException1.main( a);
            System.out.println("Outer block.");
        }
    }
}