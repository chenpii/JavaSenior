package com.ch.java;

import org.junit.Test;

import java.util.List;

/**
 * @author chenpi
 * @create 2022-02-28 10:40
 */
public class GenericTest1 {
    @Test
    public void test() {
        //如果定义了泛型，在实例化时没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("123");

        //建议：实例化时指明泛型的类型
        Order<String> order1 = new Order<>();
        order1.setOrderT("订单信息");
    }

    @Test
    public void test1() {
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型类型。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1122);

        //子类保留泛型
        SubOrder1<Integer> integerSubOrder1 = new SubOrder1<>();
        integerSubOrder1.setOrderT(123);
    }

    //测试泛型方法
    @Test
    public void test2() {
        Order<String> order = new Order<>();
        Integer[] integers = {1, 2, 3, 4};
        List<Integer> list = order.copyFromArrayListToList(integers);
        System.out.println(list);
    }
}
