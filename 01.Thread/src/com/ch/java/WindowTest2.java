package com.ch.java;

/**
 * 例子：创建三个窗口卖票，总票数100张。使用继承Thread类的方式。
 *
 * @author chenpi
 * @create 2021-12-12 16:01
 */
class Window extends Thread {

    public static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":卖票，票号为" + ticket);
                ticket--;
            } else {
                break;
            }

        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}


