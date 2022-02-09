package com.ch.exer;

/**
 * @author chenpi
 * @create 2022-02-09 19:34
 */
public class Persion implements Comparable{
    private String name;
    private int age;

    public Persion() {
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Persion){
         Persion p = (Persion) o;
         return this.getName().compareTo(p.getName());
        }
        throw new RuntimeException("输入的数据类型不一致");
    }
}
