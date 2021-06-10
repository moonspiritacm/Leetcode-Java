package com.moonspirit.concurrency;

/**
 * 生产者类
 */
public class Producter implements Runnable {
    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    /**
     * 进货：每隔200ms向售货员发货一件，最多进货20次。
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();
        }
    }
}
