package com.ch.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中（之后TreeSet需要使用泛型来定义），分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * <p>
 * ①使Employee实现Comparable接口，并按name排序。
 * <p>
 * ②创建TreeSet时传入Comparator对象，按生日日期的先后排序。
 *
 * @author chenpi
 * @create 2022-02-20 16:01
 */
public class EmployeeTest {


    //问题二：按生日的升序排
    @Test
    public void test2() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    if ((b1.getYear() - b2.getYear()) != 0) {
                        return b1.getYear() - b2.getYear();
                    } else if ((b1.getMonth() - b2.getMonth()) != 0) {
                        return b1.getMonth() - b2.getMonth();
                    } else {
                        return b1.getDay() - b2.getDay();
                    }
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        Employee e1 = new Employee("Tom", 45, new MyDate(1965, 5, 1));
        Employee e2 = new Employee("Jack", 17, new MyDate(1978, 8, 1));
        Employee e3 = new Employee("Amy", 34, new MyDate(2015, 8, 15));
        Employee e4 = new Employee("Jim", 28, new MyDate(2015, 12, 1));
        Employee e5 = new Employee("Merry", 30, new MyDate(2015, 8, 1));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    //问题一：使用自然排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("Tom", 45, new MyDate(1965, 5, 1));
        Employee e2 = new Employee("Jack", 17, new MyDate(1978, 8, 1));
        Employee e3 = new Employee("Amy", 34, new MyDate(2001, 2, 1));
        Employee e4 = new Employee("Jim", 28, new MyDate(2015, 8, 1));
        Employee e5 = new Employee("Merry", 30, new MyDate(2009, 12, 1));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next);
        }

    }
}
