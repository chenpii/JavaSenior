package com.ch.java;

/**
 * 商品类
 *
 * @author chenpi
 * @create 2022-02-09 17:05
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:按照价格升序,再按商品名称降序
    @Override
    public int compareTo(Object o) {

        if (o instanceof Goods) {
            Goods goods = (Goods) o;

            //方式一:自己写
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
//                return 0;
                return -this.name.compareTo(goods.name);
            }

            //方式二：调用包装类的方法
            //return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
