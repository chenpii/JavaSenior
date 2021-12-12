package com.ch.java.thread.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现Runnable接口的类
 * 2.实现类重写run()
 * 3.创建实现类对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 * @author chenpi
 * @create 2021-12-12 16:07
 */

class MIThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MIThread miThread = new MIThread();
        Thread t1 = new Thread(miThread);
        t1.setName("线程1");
        t1.start();
        
        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(miThread);
        t2.setName("线程2");
        t2.start();
    }
}
