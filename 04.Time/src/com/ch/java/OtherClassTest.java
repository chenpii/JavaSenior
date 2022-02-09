package com.ch.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和  BigDecimal
 *
 *
 * @author chenpi
 * @create 2022-02-09 18:18
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaVersion =System.getProperty("java.version");
        System.out.println("java的version："+javaVersion);

        String javaHome =System.getProperty("java.home");
        System.out.println("java的home："+javaHome);

        String osName =System.getProperty("os.name");
        System.out.println("os的name："+osName);

        String osVersion =System.getProperty("os.version");
        System.out.println("os的version："+osVersion);

        String userName =System.getProperty("user.name");
        System.out.println("user的name："+userName);

        String userHome =System.getProperty("user.home");
        System.out.println("user的home："+userHome);

        String userDir =System.getProperty("user.dir");
        System.out.println("user的dir："+userDir);
    }

    @Test
    public void test2(){
        BigInteger bi = new BigInteger("1243324112388955565554532135465127745");
        System.out.println(bi);

        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");

        System.out.println(bd.divide(bd2,BigDecimal.ROUND_CEILING));
        //bd除以bd2，结果四舍五入
        //1130.487

        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_CEILING));
        //bd除以bd2，结果四舍五入保留15位小数
        //1130.486454545454546

    }
}
