package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * List方法：
 * void add(int index,Object ele) ：在index位置插入ele元素。
 * boolean addAll(int index , Collection eles)：从index位置开始将eles中的所有元素添加进来。
 * Object get(int index) ：获取指定index位置的元素。
 * int indexOf(Object obj)：返回obj在集合中首次出现的位置。
 * int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置。
 * Object remove(int index)：移除指定index位置的元素，并返回元素。
 * Object set(int index,Object ele)：设置指定index位置的元素为ele。
 * List sublist(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置的子集合。
 *
 *
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index)/remove(Object obj)
 * 改：set(int index,Object ele)
 * 查：get(int index)
 * 插：add(int index,Object ele)
 * 长度：size()
 * 遍历：①Iterator迭代器方式
 *      ②增强for循环
 *      ③普通for循环
 *
 *
 *
 * @author chenpi
 * @create 2022-02-18 15:21
 */
public class ListTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("abc");
        list.add(new Person("Tom", 23));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele) ：在index位置插入ele元素。
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index , Collection eles)：从index位置开始将eles中的所有元素添加进来。
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());//9

        //Object get(int index) ：获取指定index位置的元素。
        System.out.println(list.get(0));
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("abc");
        list.add(new Person("Tom", 23));
        list.add(456);

        //int indexOf(Object obj)：返回obj在集合中首次出现的位置。
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置。
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index)：移除指定index位置的元素，并返回元素。
        Object obj = list.remove(0);
        System.out.println(list);
        System.out.println(obj);

        //Object set(int index,Object ele)：设置指定index位置的元素为ele。
        list.set(1,"CC");
        System.out.println(list);

        //List sublist(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置的子集合。
        List subList = list.subList(0,1);
        System.out.println(subList);
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("abc");
        list.add(new Person("Tom", 23));
        list.add(456);

        //迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("*************分隔符************");
        //增强for循环
        for(Object obj: list){
            System.out.println(obj);
        }
    }
}
