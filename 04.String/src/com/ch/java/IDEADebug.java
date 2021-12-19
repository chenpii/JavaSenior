package com.ch.java;

import org.junit.Test;

/**
 * @author chenpi
 * @create 2021-12-19 21:36
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//"n" "u" "l" "l"

        System.out.println(sb.length());//4

        System.out.println(sb);//null

        StringBuffer sb1 = new StringBuffer(str);//空指针异常
        System.out.println(sb1);
    }
}
