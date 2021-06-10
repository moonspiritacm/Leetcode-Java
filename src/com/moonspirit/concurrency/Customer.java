package com.moonspirit.concurrency;

/**
 * 消费者类
 */
public class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    /**
     * 买货：不间断地向售货员买货，最多买货20次。
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            clerk.sale();
        }
    }
}
