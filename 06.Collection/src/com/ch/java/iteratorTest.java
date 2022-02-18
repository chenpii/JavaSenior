package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator迭代器
 *
 * @author chenpi
 * @create 2022-02-18 13:43
 */
public class iteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());

        //遍历集合
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历时删除def
        iterator=coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if("def".equals(obj)){
                iterator.remove();
            }
        }
        iterator=coll.iterator();//再遍历需要重新获取迭代器对象
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
