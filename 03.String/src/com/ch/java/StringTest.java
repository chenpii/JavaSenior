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
}
