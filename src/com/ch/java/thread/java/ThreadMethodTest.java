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
 * 8.sleep(long millis) 让当前线程“睡眠”指定的毫秒。在指定的毫秒时间内，当前线程是阻塞状态。
 * <p>
 * 9.isAlive() 判断当前线程是否存活
 * <p>
 * <p>
 * 线程的优先级：
 * 1.
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 * MAX_PRIORITY = 10
 * <p>
 * 2.如何获取和设置当前线程的优先级
 * setPriority(int p)
 * getPriority()
 *
 * @author chenpi
 * @create 2021-12-08 14:52
 */
public class ThreadMethodTest {
    public static void main(String[] args) {

        //给分线程命名
        HelloThread h1 = new HelloThread("线程一");
        //给分线程设定优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();


        //给主线程命名
        Thread.currentThread().setName("主线程");
        //给分线程设定优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
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