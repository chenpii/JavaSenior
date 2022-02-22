package com.ch.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("tom",24);
        stringIntegerHashMap.put("Jack",23);
        stringIntegerHashMap.put("Amy",24);
        stringIntegerHashMap.put("Merry",27);
        //编译报错
//        stringIntegerHashMap.put("Jerry","12");
        System.out.println("**********");
        for (String s : stringIntegerHashMap.keySet()) {
            Integer value = stringIntegerHashMap.get(s);
            System.out.println(value);

        }
    }
}
