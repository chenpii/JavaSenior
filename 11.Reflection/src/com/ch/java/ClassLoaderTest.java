package com.ch.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解ClassLoader
 *
 * @author chenpi
 * @create 2022-03-18 15:13
 */
public class ClassLoaderTest {

    @Test
    public void test1() {

        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent()方法，可以获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent()方法，是无法获取引导类加载器
        //引导类加载器主要负责加载Java核心类库，无法加载自定义类。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClass().getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties pro = new Properties();

        //读取配置文件
        //方式一：文件在当前module下
        // FileInputStream fis = new FileInputStream("jdbc.properties");
        // pro.load(fis);

        //方式二：类加载器，文件在当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println("user=" + user);
        System.out.println("password=" + password);
    }
}
