package com.ch.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenpi
 * @create 2022-02-09 16:52
 * <p>
 * 背景：java中的对象正常情况下只能进行 == 或 != 的比较，不能使用 < 或 > 。
 * 在实际开发中，需要对多个对象进行排序，即比较对象的大小。
 * <p>
 * 如何实现？
 * 使用两个接口中的任何一个Comparable或Comparator。
 */
public class CompareTest {
    /*
    Comparable使用举例：（自然排序）

    1.String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式。
    2.String、包装类重写compareTo()方法后，进行了从小到大的排序。
    3.重写compareTo(obj)方法的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果两个对象相等，返回零。

    4.对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口
        在compareTo(obj)中指明如何排序。
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "DD", "CC", "BB"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));//[AA, BB, CC, DD]

    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 65);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //排序结果
//        [Goods{name='xiaomiMouse', price=12.0},
//        Goods{name='lenovoMouse', price=34.0},
//        Goods{name='dellMouse', price=43.0},
//        Goods{name='microsoftMouse', price=65.0},
//        Goods{name='huaweiMouse', price=65.0}]

    }


    /*
    二、Comparator接口的使用:定制排序
    1.背景
        当元素的类型没有实现Comparable接口，并且不方便修改代码，
        或者实现了Comparable接口的排序规则不适合当前的操作，
        那么可以考虑使用Comparator的对象来排序。

    2.重写compare(Object o1,Object o2)方法的规则：
        如果o1大于o2，则返回正整数，
        如果o1小于o2，则返回负整数，
        如果两个对象相等，返回零。
     */
    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "DD", "CC", "BB"};
        Arrays.sort(arr, new Comparator() {

            //按字符串降序排
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 65);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:产品名称升序，再按照价格降序。
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;

                    if (goods1.getName().equals(goods2.getName())) {
                        return -Double.compare(goods1.getPrice(), goods2.getPrice());
                    } else {
                        return goods1.getName().compareTo(goods2.getName());
                    }
                }

                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
        //排序结果
//        [Goods{name='dellMouse', price=43.0},
//        Goods{name='huaweiMouse', price=65.0},
//        Goods{name='lenovoMouse', price=34.0},
//        Goods{name='microsoftMouse', price=65.0},
//        Goods{name='xiaomiMouse', price=12.0}]

    }
}
