package com.ch.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author chenpi
 * @create 2022-01-12 20:28
 */
public class JDK8DateTime {

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：LocalDateTime用的频率较高

     */
    @Test
    public void test1(){
        //实例化
        //方式一：now() 获取当前的日期、时间、日期和时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //方式二：of():设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 10, 1, 13, 23, 13);
        System.out.println(localDateTime1);


        //获取操作：getXxxx()方法
        //当前时间2021-01-12 20:42，周三
        System.out.println(localDateTime.getDayOfMonth());//获取本月的第几天--12
        System.out.println(localDateTime.getDayOfWeek());//获取本周的第几天--WEDNESDAY
        System.out.println(localDateTime.getDayOfYear());//获取本年的第几天--12
        System.out.println(localDateTime.getMonth());//JANUARY
        System.out.println(localDateTime.getMonthValue());//1
        System.out.println(localDateTime.getHour());//20
        System.out.println(localDateTime.getMinute());//42

        //设置操作:withXxxx()方法


    }
}
