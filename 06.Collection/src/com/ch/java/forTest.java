package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0新特性
 *
 * @author chenpi
 * @create 2022-02-18 14:57
 */
public class forTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        for (Object obj: coll
             ) {
            System.out.println(obj);
        }
    }
}
