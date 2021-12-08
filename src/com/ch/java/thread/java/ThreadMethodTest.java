package com.ch.java.thread.java;

/**
 * 测试Thread的方法
 * 1.start() 启动当前线程，调用run方法
 * 2.run()  通常要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中。
 * 3.currentThread()  静态方法。返回执行当前代码的线程
 * 4.getName() 获取当前线程的名字
 * 5.setName() 设置当前线程的名字
 * 6.yield() 释放当前cpu的执行权
 * 7.join() 在线程a中调用进程b的join() ，此时a线程就进入阻塞状态，
 * 直到线程b完全执行完以后，线程a才结束阻塞状态。
 * 8.sleep(long millis)
 *
 * @author chenpi
 * @create 2021-12-08 14:52
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("线程一");
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i==20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i % 20 == 0) {
                yield();
            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}