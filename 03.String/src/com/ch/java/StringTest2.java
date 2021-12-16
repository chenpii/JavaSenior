package com.ch.java;

/**
 * @author chenpi
 * @create 2021-12-16 14:55
 */
public class StringTest2 {
//    String str = new String("good");
    String str = "good";
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest2 ex = new StringTest2();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//test

    }
}
