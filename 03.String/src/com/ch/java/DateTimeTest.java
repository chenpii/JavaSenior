package com.ch.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK8之前 日期和时间的api测试
 *
 * @author chenpi
 * @create 2021-12-19 16:44
 */
public class DateTimeTest {
    /*
    java.util.Date类
            /----java.sql.Date类

    1.两个构造器的使用
        >构造器一：Date() :创建一个对应当前时间的Date对象
        >构造器二：创建指定时间戳的Date对象
    2.两个方法的使用
        >toString():显示当前Date对象的年、月、日、时、分、秒
        >getTime():获取Date对象的时间戳

    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >sql.Date ---> util.Date  向上转型，直接赋值
        >until.Date ---> sql.Date

     */
    @Test
    public void test2() {

        //构造器一：Date() :创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//1639904830266

        //构造器二：创建指定时间戳的Date对象
        Date date1 = new Date(1639904830266L);

        //创建java.sql.Date对象
        java.sql.Date date2 = new java.sql.Date(1639904830266L);
        System.out.println(date2);//2021-12-19


        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(1639904830266L);
//        java.sql.Date date5 = (java.sql.Date) date4;

        //情况二：
        Date date6 =new Date();
        java.sql.Date date7 =new java.sql.Date(date6.getTime());
    }

    //1.System类中的currentTimeMillis() 时间戳
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);

    }
}
