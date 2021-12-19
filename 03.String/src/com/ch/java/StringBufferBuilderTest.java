package com.ch.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuild的使用
 *
 * @author chenpi
 * @create 2021-12-19 15:40
 */
public class StringBufferBuilderTest {
    /*
    String、StringBuffer、StringBuilder三者的异同？
    String：不可变的字符序列。底层使用char[]存储。
    StringBuffer：可变的字符序列。线程安全的，效率低。底层使用char[]存储。
    StringBuilder：可变的字符序列。jdk5.0新增的，线程不安全的，效率高。底层使用char[]存储。

    源码分析：
    String str = new String(); //char[] value = new char[0];
    String str1= new String("abc"); //char[] value = new char[]{'a','b','c'};

    StringBuffer sb1 =new StringBuffer();//char[] value =new char[16];
    sb1.append('a');//value[0]='a';
    sb1.append('b');//value[1]='b';

    StringBuffer sb2 = new StringBuffer("abc")//char[] value = new char["abc".length()+16];

    //问题1.System.out.println(sb2.length); //3
    //问题2.扩容问题：如果要添加的数据底层数组放不下，那就需要扩容底层的数组。
                    默认情况下，扩容为原来容量的2倍+2，同时将原有数组赋值到新数组中。

                    指导意义：开发中建议大家使用：StringBuffer(int capacity)或者StringBuilder(int capacity)
     */

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }
}
