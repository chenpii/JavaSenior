package com.ch.java;

import org.junit.Test;

/**
 * @author chenpi
 * @create 2021-12-19 14:01
 */
public class StringMethodTes {
    @Test
    public void test4() {
        String s1 = "中国美国法国";
        System.out.println(s1.replace("法","德"));
        System.out.println(s1.replace("美国","加拿大"));

        String s2 ="12hello34world5java7891mysql456";
        //把字符串中的数字替换成， 如果结果中开头和结尾有， 的话 去掉
        String s3 =s2.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(s3);//hello,world,java,mysql

        String s4 ="12345";
        //判断字符串中是否全部由数组组成
        System.out.println(s4.matches("\\d+"));

        String s5 ="0517-1234567";
        //判断是否时杭州的固定号码
        System.out.println(s5.matches("0517-\\d+"));

        String s6 ="hello|world|java|mysql";
        String[] strs =s6.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]); //hello world java mysql
        }

        String[] str2 =s6.split("\\|",3);
        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]); //hello world java|mysql
        }
    }
    @Test
    public void test3() {
        String s1 = "HelloWorld";
        System.out.println(s1.endsWith("rld"));//true
        System.out.println(s1.startsWith("hel"));//false
        System.out.println(s1.startsWith("llo", 2));//true

        System.out.println(s1.contains("oWo"));//true

        System.out.println(s1.indexOf("lo"));//3
        System.out.println(s1.indexOf("lol"));//-1

        System.out.println(s1.indexOf("lo",5));//-1

        String s2 ="hellorworld";
        System.out.println(s2.lastIndexOf("or"));//7
        System.out.println(s2.lastIndexOf("or",6));//4
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";

        System.out.println(s1.equals(s2));//false
        System.out.println(s1.equalsIgnoreCase(s2));//true

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);//abcdef

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2

        System.out.println(s1.substring(2));//lloWorld
        System.out.println(s1.substring(2, 5));//llo,左闭右开[)
    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());//10

        System.out.println(s1.charAt(0));//H
        System.out.println(s1.charAt(9));//d

        String s2 = "";
        System.out.println(s1.isEmpty());//false
        System.out.println(s2.isEmpty());//true


        System.out.println(s1.toLowerCase());//helloworld
        System.out.println(s1.toUpperCase());//HELLOWORLD
        System.out.println(s1);//s1本身没变

        String s3 = "   he llo world    ";
        System.out.println(s3.trim());//he llo world
    }


}
