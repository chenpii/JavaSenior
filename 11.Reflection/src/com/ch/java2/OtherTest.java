package com.ch.java2;

import com.ch.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chenpi
 * @create 2022-03-22 17:08
 */
public class OtherTest {

    /*
    获取运行时类的构造器
     */
    @Test
    public void test1() {
        Class clazz = Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor cons : constructors) {
            System.out.println(cons);
        }

        System.out.println("************************");

        //getDeclaredConstructors()：获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors) {
            System.out.println(cons);
        }
    }

    /*
   获取运行时类的父类
    */
    @Test
    public void test2() {
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
   获取运行时类的带泛型的父类
    */
    @Test
    public void test3() {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类的带泛型的父类的泛型
    */
    @Test
    public void test4() {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = type.getActualTypeArguments();

        System.out.println(actualTypeArguments[0].getTypeName());

    }

    /*
    获取运行时类实现的接口
    */
    @Test
    public void test5() {
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    /*
   获取运行时类所在的包
   */
    @Test
    public void test6() {
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
    获取运行时类声明的注解
    */
    @Test
    public void test7() {
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno);

        }
    }
}
