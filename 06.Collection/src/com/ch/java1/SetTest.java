package com.ch.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1.接口框架
 * /-------Collection接口：单列集合
 * /---List:有序、可重复的数据
 * /---Set:无序、不可重复的数据
 * /---HashSet：作为Set接口的主要实现类；线程不安全；可以存储null
 * /---LinkedHashSet：作为HashSet的子类；遍历内部数据时，可以按照添加的顺序遍历。
 * /---TreeSet：底层为红黑树。可以按照添加对象的指定属性，进行排序。
 *
 * 2.无序性、不可重复性
 *
 * @author chenpi
 * @create 2022-02-20 12:14
 */
public class SetTest {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new User("Tom", 23));
        set.add(new User("Tom", 23));
        set.add(456);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("");
    }

    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new User("Tom", 23));
        set.add(new User("Tom", 23));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("");
    }
}