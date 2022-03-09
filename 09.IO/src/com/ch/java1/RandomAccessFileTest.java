package com.ch.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author chenpi
 * @create 2022-03-07 15:42
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("photomode.png"), "r");
            raf2 = new RandomAccessFile(new File("photomode2.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {

        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("testRandomAccessFile.txt", "rw");

            raf1.write("xyz".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("testRandomAccessFile.txt", "rw");

            raf.seek(3);//将指针调整到角标为3的位置
            raf.write("abc".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现数据的插入
     */
    @Test
    public void test4() {
        RandomAccessFile raf = null;
        try {
            String filename = "testRandomAccessFile.txt";

            raf = new RandomAccessFile(filename, "rw");

            raf.seek(3);//将指针调整到角标为3的位置

            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder stringBuilder = new StringBuilder((int) new File(filename).length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len));
            }

            //调回指针，写入数据
            raf.seek(3);
            raf.write("abc".getBytes());
            raf.write(new String(stringBuilder).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
