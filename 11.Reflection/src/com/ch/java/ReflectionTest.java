package com.ch.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chenpi
 * @create 2022-03-15 19:14
 */
public class ReflectionTest {

    //反射之前对于Person类的操作
    @Test
    public void test1() {
        //1.实例化对象
        Person p1 = new Person("Tom", 21);

        //2.通过对象调方法
        p1.age = 12;
        System.out.println(p1.toString());

        p1.show();

        //在Person类的外部，不可以通过Person类的对象调用其内部的私有结构。
        //比如name、showNation()以及私有的构造器


    }

    //反射以后，对于Person类的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;

        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 21);
        Person p1 = (Person) obj;

        //2.通过反射，调用 对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p1, 12);
        System.out.println(p1.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);
        System.out.println(p1.toString());

        System.out.println("***********************************");

        //通过反射，可以调用Person类的私有结构，比如私有构造器、私有属性、私有方法
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = (Person) cons1.newInstance("Jerry");
        System.out.println(p2);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"HanMeiMei");
        System.out.println(p2);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于p1.showNation("中国")
        System.out.println(nation);

    }

    //获取Class实例
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.ch.java.Person");
        System.out.println(clazz3);
		
		System.out.println(clazz1==clazz2);//ture
		System.out.println(clazz1==clazz3);//ture
		
		//方式四：类的加载器：ClassLoader  (了解)
		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
		Class clazz4 = classLoader.loadClass("com.ch.java.Person");
		System.out.println(clazz4);
		System.out.println(clazz1==clazz4);//ture

    }
	
	//哪些类可以有Class对象
	@Test
	public void test4(){
		Class c1 = Object.class;
		Class c2 = Comparable.class;
		Class c3 = String[].class;
		Class c4 = int[][].class;
		Class c5 = ElementType.class;
		Class c6 = Override.class;
		Class c7 = int.class;
		Class c8 = void.class;
		Class c9 = Class.class;
		
		int[] a = new int[10];
		int[] b = new int[100];
		Class c10 = a.getClass();
		Class c11 = b.getClass();
		//只要元素类型和纬度一样，就是同一个Class
		System.out.println(c10==c11);//true
	}
}
