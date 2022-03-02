package com.ch.java;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的使用
 * 节点流	            缓冲流
 * FileInputStream	    BufferedInputStream
 * FileOutputStream	    BufferedOutputStream
 * FileReader	        BufferedReader
 * FileWriter	        BufferedWriter
 *
 * @author chenpi
 * @create 2022-03-02 21:54
 */
public class BufferedTest {


    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("photomode.png");
            File destFile = new File("photomode2.png");

            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略。
//        fos.close();
//        fis.close();
        }
    }

    //实现非文本文件的复制
    public void copyFileWithBuffered(String srcPath, String destPath) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();

        String srcPath = "E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\01-video.mp4";
        String destPath = "E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\02-video.mp4";

        copyFileWithBuffered(srcPath, destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间：" + (end - start));//416

    }

    /**
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter() {
        //1.造文件
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2.造流
            //2.1节点流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);
            //2.2缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //3.读写数据
            char[] cbuffer = new char[1024];
            int len;
            while ((len = br.read(cbuffer)) != -1) {
                bw.write(cbuffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


