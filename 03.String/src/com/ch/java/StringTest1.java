package com.ch.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author chenpi
 * @create 2021-12-19 15:10
 */
public class StringTest1 {

    /*
    String 与 byte[]转换
    String --> byte[]  :调用String的getBytes()
    byte[] --> String  :调用String 的构造器

    编码：字符串 --> 字节
    解码：编码的逆过程 字节--> 字符串
    解码时，使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。

     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));


        String s2 = new String(bytes);
        System.out.println(s2);

        String s3 = new String(gbks);
        System.out.println(s3);//乱码。编码集与解码集不一致

        String s4 = new String(gbks, "gbk");
        System.out.println(s4);

    }


    /*
    String 与 char[]转换
    String --> char[]:  调用String.toCharArray()
    char[] -->String :  调用String 的构造器

     */
    @Test
    public void test2() {
        String s1 = "abc123";

        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] charArray2 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(charArray2);
        System.out.println(s2);

    }

    /*
    String 与基本数据类型、包装类之间的转换

    String --> 基本数据类型、包装类:调用包装类的静态方法parseXxx(str)
    基本数据类型、包装类 --> String :调用String重载的valueOf(xxx)
     */
    @Test
    public void test1() {
        String s1 = "123";
        int num = Integer.parseInt(s1);

        String s2 = String.valueOf("123");
        String s3 = num + "";

        System.out.println(s1 == s3);

    }
}
