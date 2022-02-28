package com.ch.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型的继承
 * <p>
 * 2.通配符
 *
 * @author chenpi
 * @create 2022-02-28 20:47
 */
public class GenericTest {
    /**
     * 1.继承
     * 虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
     * 比如 ArrayList<Object> 和 ArrayList<String>  是并列关系。
     * <p>
     * 类A是类B的父类，A<G>是B<G>父类。
     * 例如 List<String> 和 ArrayList<String>
     */
    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;


        List<Object> list1 = null;
        List<String> list2 = null;
        //不具备子父类关系
//        list1 = list2;

        show1(list1);
        show2(list2);
    }

    public void show1(List<Object> list) {

    }

    public void show2(List<String> list) {

    }

    @Test
    public void test2() {
        //存在继承关系
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<String>();
    }

    /**
     * 2.通配符
     * 通配符：？
     * <p>
     * 类A是类B的父类
     */

    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        //编译通过
//        print(list1);
//        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加（写入）:对于List<?>就不能向其内部添加数据。
        //除了添加null之外
//        list.add("DD");
        list.add(null);

        //获取:允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 有限制条件的通配符使用
     * ? extends Person:所有继承了Person类的子类，包括Person本身。
     * ? super Person:所有Person的父类，包括Person本身。
     */
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读数据
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);

        list2 = list4;
        Object object = list2.get(0);
        //编译不通过
//        Person per =list2.get(0);

        //写数据
        //编译不通过
//        list1.add(new Student());

        list2.add(new Person());

    }

}
