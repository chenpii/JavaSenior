package com.ch.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8之前的日期时间的API测试
 * 1.System.currentTimeMillis()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat类
 * 4.Calendar日历类
 *
 * @author chenpi
 * @create 2021-12-19 21:58
 */
public class DateTimeTest {

    /*
    SimpleDateFormat类使用：   对日期Date类的格式化和解析

    1.两个操作：
        1.1.格式化：日期 -->字符串
        1.2.解析：字符串-->日期

    2.实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化:使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 -->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串-->日期
        String str = "21-12-19 下午10:06";
        Date date2 = sdf.parse(str);
        System.out.println(date2);

        //*******************************************
        //实例化：指定方式构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化：日期 -->字符串
        String format1 = sdf1.format(new Date());
        System.out.println(format1);

        //解析：字符串-->日期
        String str2 = "2021-12-19 10:17:11";
        Date parse = sdf1.parse(str2);
        System.out.println(parse);
    }


    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }

    /*
    练习二："三天打鱼两天晒网" 1990-01-01 xxxx-xx-xx 打鱼？晒网？

    举例：2020-09-08？总天数
    总天数 % 5 = 1,2,3 ：打鱼
    总天数 % 5 = 4,0   ：晒网

    计算总天数？
    方式一： (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) 能除尽，不用+1
    方式二：

     */
    @Test
    public void testFishOrRest() throws ParseException {
        String startDay = "1990-01-01";
        String endday = "1990-01-07";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startparse = sdf.parse(startDay);
        Date endparse = sdf.parse(endday);

        long countDays = endparse.getTime() - startparse.getTime();
        int num = (int) ((countDays / (1000 * 60 * 60 * 24)) % 5);
        if (num ==1||num ==2||num ==3){
            System.out.println("打鱼");
        }else{
            System.out.println("晒网");
        }
    }

    /*
    Calendar日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类GregorianCalendar对象
        //方式二：调用getInstance方法
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//当月的第几天
        System.out.println(days);

        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//当年的第几天

        //set()

        //add()

        //getTime()

        //setTime()


    }
}
