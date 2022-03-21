package com.ch.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类对象
 *
 * @author chenpi
 * @create 2022-03-21 10:19
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
        newInstance()：调用此方法，创建对应的运行时类对象。内部调用了运行时类的空参构造器。
		
		要想此方法正常的创建运行时类对象，要求：
		1.运行时类必须提供空参的构造器。
		2.需有权限访问空参构造器。通常为public
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    @Test
    public void test2() {
        int num = new Random().nextInt(3);//0,1,2
        String className = "";
        switch (num) {
            case 0:
                className = "java.util.Date";
                break;
            case 1:
                className = "java.sql.Date";
                break;
            case 2:
                className = "com.ch.java.Person";
                break;
        }
        try {
            Object obj = getInstance(className);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建一个指定类的对象
     *
     * @param classPath 指定类的全类名
     * @return
     * @throws Exception
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
