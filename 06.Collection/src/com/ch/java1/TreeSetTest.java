package com.ch.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * /---TreeSet：底层为红黑树。可以按照添加对象的指定属性，进行排序。
 *
 * @author chenpi
 * @create 2022-02-20 13:37
 */
public class TreeSetTest {

    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        //不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("abc");
//        set.add(new User("Tom",23));

        //举例一
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：自定义类
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄升序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o1 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入的类型数据不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Mary", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
