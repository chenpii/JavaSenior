package com.ch.java;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author chenpi
 * @create 2022-02-21 10:24
 */
public class DecimalFormatrTest {
    @Test
    public void test() {
        //double保留2位小数
        Double differ = -41.24000000000001;

        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(differ);
        System.out.println(str);
        differ = Double.valueOf(str);
        System.out.println(differ);

    }
}
