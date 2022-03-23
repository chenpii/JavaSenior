package com.ch.java2;

import com.ch.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

        /*
        1.获取指定的某个方法
        getDeclaredMethod()
            参数1：指明获取的方法的名称
            参数2：指明获取的方法的参数列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证当前方法可访问
        show.setAccessible(true);

        /*
        3.调用方法
        invoke():
            参数1：方法的调用者
            参数2：给方法的形参赋值的实参
            返回值：即为对应类中方法的返回值
         */
        Object returnValue = show.invoke(p, "China");

        System.out.println(returnValue);


        System.out.println("*************调用静态方法************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则返回null
        Object returnV = showDesc.invoke(Person.class);
        System.out.println(returnV);
    }

    /*
    如何操作运行时类中指定的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
            参数：指明构造器的参数列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器可访问
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person jack = (Person) constructor.newInstance("Jack");
        System.out.println(jack);
    }
}
