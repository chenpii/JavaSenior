package com.ch.java2;

import com.ch.java1.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的方法结构
 *
 * @author chenpi
 * @create 2022-03-22 15:04
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //获取方法
        //getMethods()：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("********************");

        //getDeclaredMethods()：获取当前运行时类中声明的所有方法。（不包含父类中声明的）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }


    /*
    @Xxx
    权限修饰符、返回值类型、方法名(参数类型1 形参名1 .....) throws XxxException{}
    */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");


            //3.返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");


            //4.方法名
            String name = m.getName();
            System.out.print(name);
            System.out.print("(");
            //5.参数列表
            Class[] types = m.getParameterTypes();
            if (!(types == null || types.length == 0)) {
                for (int i = 0; i < types.length; i++) {

                    if (i == types.length - 1) {
                        System.out.print(types[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.print(types[i].getName() + " args_" + i + ",");
                }

            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {

                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }

    }
}
