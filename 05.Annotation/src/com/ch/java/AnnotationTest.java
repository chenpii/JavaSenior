package com.ch.java;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * 注解的使用
 * 1.注解概述
 * 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。
 * 通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。
 * <p>
 * 2.常见的注解示例
 * 示例一：生成文档相关的注解
 * 示例二：编译时进行格式检查的内置的三个基本注解
 * 示例三：跟踪代码依赖性，实现代替配置文件功能
 * <p>
 * 3.自定义注解：参照@SuppressWarnings定义
 * 1.注解声明为 @interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default的定义
 * 4.如果自定义注解没有成员，表明是一个标识作用。
 * <p>
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 * <p>
 * 4.jdk5中的4个元注解
 * 元注解：对现有注解进行解释说明的注解
 * Retention:指定所修饰的注解的生命周期：SOURCE\CLASS（默认）\RUNTIME
 * 只有声明为RUNTIME的注解，才能通过反射获取。
 * <p>
 * Target：指定被修饰的Annotation 能用于修饰哪些程序元素
 * ************出现频率较低************
 * Documented:用于指定该Annotation 将被javadoc工具提取成文档
 * Inherited:用于指定该Annotation将具有继承性
 * <p>
 * 5.通过反射获取注解信息---反射部分细讲
 *
 * @author chenpi
 * @create 2022-02-15 21:26
 */
public class AnnotationTest {

    public static void main(String[] args) {
        @SuppressWarnings({"unused"})
        int num = 10;
    }


    @Test
    public void testGetAnnotation() {
        Class clazz = Student.class;
        Annotation[] annotation = clazz.getAnnotations();
        for (int i = 0; i < annotation.length; i++) {
            System.out.println(annotation[i]);
        }

    }

}

interface info {
    void show();
}

@MyAnnotation(value = "hi")
class Persion {
    private String name;
    private int age;

    public Persion() {
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("People walk");
    }

    public void eat() {
        System.out.println("People eat");
    }
}

class Student extends Persion implements info {
    @Override
    public void walk() {
        System.out.println("Student walk");
    }

    @Override
    public void eat() {
        System.out.println("Student eat");
    }

    @Override
    public void show() {

    }
}