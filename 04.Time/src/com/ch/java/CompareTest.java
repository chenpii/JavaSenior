package com.ch.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenpi
 * @create 2022-02-09 16:52
 *
 *  一、java中的对象正常情况下只能进行 == 或 != 的比较，不能使用 < 或 > 。
 *  在实际开发中，需要对多个对象进行排序，即比较对象的大小。
 *  如何实现？
 *      使用两个接口中的任何一个Comparable或Comparator。
 *
 *  二、Comparable接口的使用
 */
public class CompareTest {
    /*
    Comparable使用举例：（自然排序）
    1.String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式。
    2.String、包装类重写compareTo()方法后，进行了从小到大的排序。
    3.重写了compareTo(obj)方法的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果两个对象相等，返回零。

    4.对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口
        在compareTo(obj)中指明如何排序。
     */
    @Test
    public void test1(){
        String[] arr=new String[]{"AA","DD","CC","BB"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));//[AA, BB, CC, DD]

    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("dellMouse",43);
        arr[2]=new Goods("xiaomiMouse",12);
        arr[3]=new Goods("huaweiMouse",65);
        arr[4]=new Goods("microsoftMouse",65);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //排序结果
//        [Goods{name='xiaomiMouse', price=12.0},
//        Goods{name='lenovoMouse', price=34.0},
//        Goods{name='dellMouse', price=43.0},
//        Goods{name='microsoftMouse', price=65.0},
//        Goods{name='huaweiMouse', price=65.0}]

    }

}
