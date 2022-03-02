package com.ch.java;

import org.junit.Test;

import java.io.*;

/**
 * @author chenpi
 * @create 2022-03-02 16:02
 */
public class FileInputOutStreamTest {

    @Test
    public void testFileInputStream() {

        //1.造文件
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] bbuff = new byte[5];
            int len;
            while ((len = fis.read(bbuff)) != -1) {
                String str = new String(bbuff, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 实现对图片的复制
     */
    @Test
    public void testFileInputOutputStream() {
        //1.实例化file对象
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("photomode.png");
            File destfile = new File("photomode2.png");

            //2.实例化流对象
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //3.读写数据
            byte[] bbuff = new byte[5];
            int len;
            while ((len = fis.read(bbuff)) != -1) {
                fos.write(bbuff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath) {
        //1.实例化file对象
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            //2.实例化流对象
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //3.读写数据
            byte[] bbuff = new byte[1024];
            int len;
            while ((len = fis.read(bbuff)) != -1) {
                fos.write(bbuff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();

        String srcPath="E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\01-video.mp4";
        String destPath="E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\02-video.mp4";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间：" + (end - start));//1477
    }

}
