package com.it.sim.thread.lock;

/**
 * @date 2022-10-11 16:25
 */
public class TestSynchronizedAdd2 {
    JManager j = new JManager();

    public static void main(String[] args) {
        new TestSynchronizedAdd2().call();

    }

    void call() {
        for (int i = 0; i < 2; i++) {
            new Thread(
                    () -> {
                        while (true) {
                            j.accumulate();
                        }
                    }
            ).start();
            new Thread(() -> {
                while (true) {
                    j.subtract();
                }
            }).start();
        }
    }
}
class JManager {
    private int j = 0;

    public synchronized void subtract() {
        j--;
    }

    public synchronized void accumulate() {
        j++;
    }

}