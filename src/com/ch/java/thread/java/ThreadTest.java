package com.ch.java.thread.java;

/**
 * @author chenpi
 * @create 2021-12-08 9:30
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //新建线程
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();

        //main线程
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("**********main()主线程中：" + i);
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "线程中：" + i);
            }
        }
    }
}