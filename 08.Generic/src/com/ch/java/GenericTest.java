package com.ch.java;

import org.junit.Test;

import java.util.*;

/**
 * @author chenpi
 * @create 2022-02-22 13:45
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);

        //编译时报错
//        arrayList.add("12");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("tom",24);
        map.put("Jack",23);
        map.put("Amy",24);
        map.put("Merry",27);
        //编译报错
//        stringIntegerHashMap.put("Jerry","12");
        System.out.println("**********");
        for (String s : map.keySet()) {
            Integer value = map.get(s);
            System.out.println(value);

        }

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
    }
}
