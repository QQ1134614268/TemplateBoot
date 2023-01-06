package com.it.sim.jvm.javamemory;
// 栈溢出异常

// -Xss128k
public class JavaVMStackSOF {
    private int stackLength = 1;

    @SuppressWarnings("InfiniteRecursion")
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println(oom.stackLength);
            throw e;
        }
    }
}
//993
// Exception in thread "main" java.lang.StackOverflowError
// 	at com.it.JavaMemory.JavaVMStackSOF.stackLeak(com.it.JavaMemory.JavaVMStackSOF.java:6)
// 	at com.it.JavaMemory.JavaVMStackSOF.stackLeak(com.it.JavaMemory.JavaVMStackSOF.java:7)
// 	at com.it.JavaMemory.JavaVMStackSOF.stackLeak(com.it.JavaMemory.JavaVMStackSOF.java:7)
// 	at com.it.JavaMemory.JavaVMStackSOF.stackLeak(com.it.JavaMemory.JavaVMStackSOF.java:7)
// 	at com.it.JavaMemory.JavaVMStackSOF.stackLeak(com.it.JavaMemory.JavaVMStackSOF.java:7)
//  ...
