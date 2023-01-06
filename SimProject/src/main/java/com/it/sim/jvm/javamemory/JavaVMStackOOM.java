package com.it.sim.jvm.javamemory;

// -Xss2M
public class JavaVMStackOOM {

    @SuppressWarnings("StatementWithEmptyBody")
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
