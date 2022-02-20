package com.ch.java;

import org.junit.Test;

import java.util.*;

/**
 * @author chenpi
 * @create 2022-02-20 16:51
 */
public class MapTest {
    /**
     * 元视图操作
     * Set keySet()：返回所有key构成的Set集合。
     * Collenction values()：返回所有value构成的Collection集合。
     * set entrySet()：返回所有key-value对构成的Set集合。
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);

        //遍历所有的key集keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        //遍历所有的value集：values()
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println();
        //遍历所有的key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry);
        }

        System.out.println();
        //方式二：
        Set keyset = map.keySet();
        Iterator iterator3 = keyset.iterator();
        while (iterator3.hasNext()) {
            Object key = iterator3.next();
            Object value = map.get(key);
            System.out.println(key + "---" + value);
        }

    }

    /**
     * 元素查询
     * Object get(Object key)：获取指定key对应的value。
     * boolean containsKey(Object key)：是否包含指定的key。
     * boolean containsValue(Object value)：是否包含指定的value。
     * int size()：返回map中key-value对的个数。
     * boolean isEmpty()：判断当前map是否为空。
     * boolean equals(Object obj)：判断当前map和参数对象obj是否相等。
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //get(Object key)
        Object value = map.get("BB");
        System.out.println(value);
        System.out.println(map);

        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        //containsValue(Object value)
        isExist = map.containsValue(123);
        System.out.println(isExist);

        //isEmpty()
//        map.clear();
//        System.out.println(map.isEmpty());

        //equals(Object obj)
        Map map1 = new HashMap();
        map1.put("AA", 123);
        map1.put(45, 123);
        map1.put("BB", 56);
        System.out.println(map.equals(map1));


    }

    /**
     * 添加、删除、修改
     * Object put(Object key,Object value)：将指定的key-value添加(修改)到当前map对象中。
     * void putAll(Map m)：将m中所有key-value对存放到当前map中。
     * Object remove(Object key)：移除指定key-value对，并返回value。
     * void clear()：清空当前map中的所有数据。
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object obj = map.remove("CC");
        System.out.println(obj);
        System.out.println(map);

        //void clear()
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }
}
