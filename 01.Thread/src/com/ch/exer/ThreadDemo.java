package com.ch.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 * @author chenpi
 * @create 2021-12-08 14:24
 */
public class ThreadDemo {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        oddThread.start();
        EvenThread evenThread = new EvenThread();
        evenThread.start();

        //创建Thread匿名子类方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "匿名类" + i);
                    }
                }
            }
        }.start();
    }
}

/**
 * 遍历奇数的线程
 */
class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "奇数线程：" + i);
            }
        }
    }
}

/**
 * 遍历偶数线程
 */
class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数线程：" + i);
            }
        }
    }
}