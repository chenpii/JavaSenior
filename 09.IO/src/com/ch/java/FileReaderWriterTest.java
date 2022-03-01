package com.ch.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 抽象基类             节点流                 缓冲流（处理流的一种）
 * InputStream          FileInputStream         BufferedInputStream
 * OutputStream         FileOutputStream        BufferedOutputStream
 * Reader               FileReader              BufferedReader
 * Writer               FileWriter              BufferedWriter
 *
 * @author chenpi
 * @create 2022-03-01 20:45
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 将hello.txt的文件内容读入程序中，并输出到控制台
     * 1.read()：返回读入的一个字符。如果达到文件末尾，返回-1。
     * 2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally来处理。
     * 3.读入的文件一定要存在，否则会报FileNotFoundException。
     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化file对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前module
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.实例化file对象
            File file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read(char cbuf[]) :返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1。
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
                //方式一：遍历数组
                //错误的写法
//                for (int i = 0; i < cbuffer.length; i++) {
//                    System.out.print(cbuffer[i]);
//                }
                //正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuffer[i]);
//                }

                //方式二：char数组转String
                String str =new String(cbuffer,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
