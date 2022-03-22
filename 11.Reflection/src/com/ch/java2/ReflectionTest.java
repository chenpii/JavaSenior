package com.ch.java2;

import com.ch.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author chenpi
 * @create 2022-03-22 19:27
 */
public class ReflectionTest {
    /*
	getField()
     */
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性:要求运行时类中的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
		set()：
			参数1：指明设置哪个对象的属性
			参数2：指明将此属性设置为多少
         */
        id.set(p, 1001);

        /*
        获取当前属性的值
		get()：
			参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /*
    如何操作运行时类中指定的属性
     */
    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取指定名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性可访问
        name.setAccessible(true);

        //3.设置、获取指定对象的属性
        name.set(p, "Tom");

        System.out.println(name.get(p));
    }


    /*
    如何操作运行时类中指定的方法
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
		

    }
}
