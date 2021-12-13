package com.ch.callabletest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现callable接口。 ---JDK5.0
 *
 * @author chenpi
 * @create 2021-12-13 21:21
 */
//1.创建一个Callable的实现类
class NumThread implements Callable {

    //2.重写call方法。将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable实现类对象
        NumThread numThread = new NumThread();

        //4.将Callable实现类对象作为参数，传递给FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(numThread);

        //5.将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread对象，调用start()方法
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()方法返回值。
            Object sum = futureTask.get();
            System.out.println("总和为："+sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
