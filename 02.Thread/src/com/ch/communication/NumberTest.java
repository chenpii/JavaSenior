package com.ch.communication;

/**
 * 实现两个线程交替打印1-100。
 *
 * @author chenpi
 * @create 2021-12-13 10:08
 */
class Number implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class NumberTest {
    public static void main(String[] args) {
        Number n1 = new Number();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
