package com.ch.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的第4种方式：线程池
 *
 * @author chenpi
 * @create 2021-12-13 21:56
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性ThreadPoolExecutor
        service1.setCorePoolSize(15);

        //2.执行指定的线程的操作。需要提供Runnable或Callable实现类对象
        //适合使用于Runnable
        service.execute(new NumberThread());
        //适合使用于Callable
//        service.submit(Callable callable);
        //3.关闭连接池
        service.shutdown();

    }
}
