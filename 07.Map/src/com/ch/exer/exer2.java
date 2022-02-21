package com.ch.exer;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，并按照分数显示前三名成绩学员的名字。
 *
 * @author chenpi
 * @create 2022-02-21 16:08
 */
public class exer2 {
    @Test
    public void test() {
        TreeSet treeSet = new TreeSet();

        Student s1 = new Student("Tom", 98);
        Student s2 = new Student("Jerry", 80);
        Student s3 = new Student("Jack", 85);
        Student s4 = new Student("Amy", 95);
        Student s5 = new Student("Bob", 100);

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);

        Iterator iterator = treeSet.iterator();
        for (int i = 0; i < 3; i++) {
            System.out.println(iterator.next());
        }
    }
}
