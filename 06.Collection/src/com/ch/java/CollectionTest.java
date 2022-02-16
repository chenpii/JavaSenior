package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection中声明方法的测试
 *
 * @author chenpi
 * @create 2022-02-15 23:20
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        Person p = new Person("Tom", 23);
        coll.add(p);

        //contains(Object obj)
        System.out.println(coll.contains("abc"));
        System.out.println(coll.contains(new String("def")));
        System.out.println(coll.contains(new Person("Tom", 23)));


    }
}
