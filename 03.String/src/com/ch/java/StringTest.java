package com.ch.java;

import org.junit.Test;

/**
 * String的使用
 *
 * @author chenpi
 * @create 2021-12-13 22:34
 */
public class StringTest {
    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); //比较s1、s2地址值 true
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s1 += "def";
        System.out.println(s1);//abcdef
        System.out.println(s2);//abc
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1);//abc
        System.out.println(s2);//mbc
    }

    @Test
    public void test4() {

        //方式一：字面量定义
        //此时s1和s2的数据声明在方法区中的字符串常量池中。
        String s1 = "abc";
        String s2 = "abc";
        //方式二：new+构造器
        //此时s3和s4保存的地址值，是数据在堆空间中开辟以后对应的地址。
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        Person p1 = new Person("小明", 21);
        Person p2 = new Person("小明", 21);

        System.out.println(p1.name == p2.name);

    }

    @Test
    public void test5() {
        String s1 = "javasee";
        String s2 = "hello";

        String s3 = "javaseehello";
        String s4 = "javasee" + "hello";
        String s5 = s1 + "hello";
        String s6 = "javasee" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true,s3、s4都在常量池中
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = (s1 + s2).intern();//返回值得到的s8使用的常量值中已经存在的"javaseehello"
        System.out.println(s3 == s8);//true

    }

    @Test
    public void test6() {

    }
}
