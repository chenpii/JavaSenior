package com.ch.java;

/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * <p>
 * 例子：创建三个窗口卖票，总票数100张。使用继承Thread类的方式。
 *
 * @author chenpi
 * @create 2021-12-12 19:54
 */
class Window2 extends Thread {

    public static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            synchronized (Window2.class) { //Window2.class 只会加载一次

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}