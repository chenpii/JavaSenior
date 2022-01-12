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

        //获取相关属性：getXxxx()方法
        //当前时间2021-01-12 20:42，周三
        System.out.println(localDateTime.getDayOfMonth());//获取本月的第几天--12
        System.out.println(localDateTime.getDayOfWeek());//获取本周的第几天--WEDNESDAY
        System.out.println(localDateTime.getDayOfYear());//获取本年的第几天--12
        System.out.println(localDateTime.getMonth());//JANUARY
        System.out.println(localDateTime.getMonthValue());//1
        System.out.println(localDateTime.getHour());//20
        System.out.println(localDateTime.getMinute());//42

        //设置相关属性:withXxxx()方法 体现不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);//设置成22号
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(4);//设置成4点
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //加减操作 plusXxx()、minusXxx()
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);//加上3个月
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
        LocalDateTime localDateTime5 = localDateTime.minusDays(1);//减1天
        System.out.println(localDateTime);
        System.out.println(localDateTime5);


    }
}
