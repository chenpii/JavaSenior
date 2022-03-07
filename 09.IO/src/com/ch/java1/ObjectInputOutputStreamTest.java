package com.ch.java1;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * 1.对象序列化机制
 * 对象序列化机制允许把内存中的Java对象转化成与平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或者通过网络将这种二进制流传输到另一个网络节点。
 * 当其他程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 * @author chenpi
 * @create 2022-03-04 17:06
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream obs = null;
        try {
            obs = new ObjectOutputStream(new FileOutputStream("object.dat"));
            obs.writeObject(new String("abc"));
            obs.flush();

            obs.writeObject(new Person("Tom",12));
            obs.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (obs != null)
                    obs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void testObjectInputStream() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            String str = (String) ois.readObject();
            System.out.println(str);

            Person p1= (Person) ois.readObject();
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
