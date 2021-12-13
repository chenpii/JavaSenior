package com.ch.communication;

/**
 * 生产者(Producer)将产品交给店员(Clerk)，
 * 而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如20)，
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1.是否是多线程问题？
 * 是，生产者线程，消费者线程
 * 2.是否有共享数据？
 * 有，产品
 * 3.如何解决线程安全问题？
 * 同步机制，三种方法
 * 4.是否涉及线程的通信？
 * 是
 *
 * @author chenpi
 * @create 2021-12-13 11:32
 */

//店员
class Clerk {
    private int productCount = 0;
    private final int MAX_SIZE = 20;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount < MAX_SIZE) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始生产产品....");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }

    }
}

//消费者
class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始消费产品....");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Customer c1 = new Customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}
