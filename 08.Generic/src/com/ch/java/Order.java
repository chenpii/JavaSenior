package com.ch.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpi
 * @create 2022-02-28 10:13
 */
public class Order<T> {
    private String orderName;
    private int orderId;
    //类的内部就可以使用类的泛型
    private T orderT;

    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    // 换句话说，泛型方法所属的类是不是泛型类都没有关系。
    public <E> List<E> copyFromArrayListToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
