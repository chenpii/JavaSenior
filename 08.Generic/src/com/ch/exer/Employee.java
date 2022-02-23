package com.ch.exer;

/**
 * 定义一个Employee类。
 *
 * 该类包含：private成员遍历 name、age、birthday，其中birthday为MyDate类的对象；
 * 为每个属性定义get、set方法；
 * 重写toString方法输出name、age、birthday
 *
 * @author chenpi
 * @create 2022-02-20 15:57
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //指明泛型的写法
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    //没指明泛型的写法
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e =(Employee) o;
//            return this.name.compareTo(e.name);
//        }
//        throw new RuntimeException("传入的类型不一致");
//    }
}
