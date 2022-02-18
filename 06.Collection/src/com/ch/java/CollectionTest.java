package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection中声明方法的测试
 *
 * @author chenpi
 * @create 2022-02-15 23:20
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        //contains(Object obj)
        System.out.println(coll.contains("abc"));
        System.out.println(coll.contains(new String("def")));
        System.out.println(coll.contains(new Person("Tom", 23)));


        //containsAll(Collection coll1)：判断形参coll1中所有的元素是都否存在于集合中
        Collection coll1 = Arrays.asList(123, "abc");
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        //3.remove(Object obj) 从当前集合中删除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        coll.remove(1234);
        System.out.println(coll);
        coll.remove(new Person("Tom", 23));
        System.out.println(coll);

        //4.removeAll(Collection coll1) 差集：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123, "abc");
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        //5.retainAll(Collection coll1) 求当前集合与coll1的交集
//        Collection coll1 = Arrays.asList(123, "abc","fff");
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj): 判断当前集合与形参元素是否一致
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add("abc");
        coll1.add(new String("def"));
        coll1.add(false);
        coll1.add(new Person("Tom", 23));

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test4() {
        //hashcode()
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("abc");
        coll.add(new String("def"));
        coll.add(false);
        coll.add(new Person("Tom", 23));

        //7.hashCode() :返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.1 集合——>数组 toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //8.1 数组——>集合 Arrays.asList()
        List<String> arr1 = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(arr);

        //9.iterator() :返回Iterator接口的实例，用于遍历集合元素。放在iteratorTest中
    }
}
