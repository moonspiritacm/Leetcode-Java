package com.moonspirit.concurrency;

/**
 * 售货员类
 */
public class Clerk {
    private int product = 0;

    /**
     * 进货：库存为0时进货，库存为1时停止进货，等待被消费。
     */
    public synchronized void add() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "：已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + "：进货成功，剩余库存 " + product);
        this.notifyAll();
    }

    /**
     * 卖货：库存为1时卖货，库存为0时停止卖货，等待补充库存。
     */
    public synchronized void sale() {
        if (product <= 0) {
            System.out.println(Thread.currentThread().getName() + ": " + "没有买到货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName() + "：卖货成功，剩余库存 " + product);
        this.notifyAll();
    }
}
