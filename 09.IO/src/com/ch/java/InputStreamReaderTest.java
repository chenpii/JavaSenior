package com.ch.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 转换流
 * @author chenpi
 * @create 2022-03-03 21:36
 */
public class InputStreamReaderTest {

    /**
     * InputStreamReader的使用：实现字节的输入流到字符的输入流的转化。
     */
    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
//            isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, "utf-8");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 综合使用InputStreamReder和OutputStreamWriter
     */
    @Test
    public void test2()  {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.文件
            File file1 = new File("hello.txt");
            File file2 = new File("hello_gbk.txt");


            //2.字节流
            FileInputStream fis1 = new FileInputStream(file1);
            FileOutputStream fis2 = new FileOutputStream(file2);

            //3.字符流
            isr = new InputStreamReader(fis1, "utf-8");
            osw = new OutputStreamWriter(fis2, "gbk");

            //4.处理数据
            char[] cbuff = new char[20];
            int len;
            while ((len = isr.read(cbuff)) != -1) {
                osw.write(cbuff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //5.关闭资源
            try {
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
