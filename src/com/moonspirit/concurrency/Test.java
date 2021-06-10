package com.moonspirit.concurrency;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producter producter = new Producter(clerk);
        Customer customer = new Customer(clerk);

        new Thread(producter, "生产者A").start();
        new Thread(customer, "消费者A").start();
        new Thread(producter, "生产者B").start();
        new Thread(customer, "消费者B").start();
        new Thread(producter, "生产者C").start();
        new Thread(producter, "生产者D").start();
        new Thread(producter, "生产者E").start();
        new Thread(producter, "生产者F").start();
        new Thread(producter, "生产者G").start();
        new Thread(producter, "生产者H").start();
        new Thread(producter, "生产者I").start();
        new Thread(producter, "生产者J").start();
    }
}
