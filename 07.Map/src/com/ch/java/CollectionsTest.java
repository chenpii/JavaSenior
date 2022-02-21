package com.ch.java;

import org.junit.Test;

import java.util.*;

/**
 * Collections：对Collection、Map进行操作的工具类
 *
 * @author chenpi
 * @create 2022-02-21 11:00
 */
public class CollectionsTest {

    /**
     * Object max(Collection) ：根据元素的自然排序，返回集合中最大元素。
     * Object max(Collection,Comparator)：根据Comparator指定的顺序，返回集合中的最大元素。
     * Object min(Collection)
     * Object min(Collection,Comparator)
     * int frequency(Collection,Object)：返回集合中指定元素出现的次数。
     * void copy(List dest,List src)：将src中的内容复制到dest中。
     * boolean replaceAll(List list,Object oldVal,Object newVal)：使用新值替换List对象的所有旧值。
     *
     */
    @Test
    public void test2(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        List list1 = Collections.synchronizedList(list);

    }

    /**
     *
     * reverse(List) 反转List中元素的顺序。
     * shuffle(List) 对List集合元素进行随机排序。
     * sort(List) 根据元素的自然排序对指定List集合元素进行升序排序。
     * sort(List,Comparator) 根据指定的Comparator产生的顺序对List集合元素进行排序。
     * swap(List，int，int) 将指定List集合中的i处元素和j处元素进行交换。
     */
    @Test
    public void test(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        System.out.println(list);
//
//        Collections.shuffle(list);
//        System.out.println(list);

//        Collections.sort(list);
//        System.out.println(list);

//        Collections.swap(list,1,2);
//        System.out.println(list);


    }
}
