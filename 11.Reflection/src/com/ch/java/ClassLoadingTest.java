package com.ch.java;

/**
 * @author chenpi
 * @create 2022-03-18 14:21
 */
public class ClassLoadingTest {

    public static void main(String[] args) {
        System.out.println(A.m);
    }
}

class A {
    static {
        m = 300;
    }

    static int m = 100;
}