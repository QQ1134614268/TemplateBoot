package com.it.sim.jvm.gc;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 执行");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        // finalize优先级低,暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead -- 1");
        }

        SAVE_HOOK = null;
        System.gc();
        // finalize优先级低,暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead -- 2");
        }
    }

}
