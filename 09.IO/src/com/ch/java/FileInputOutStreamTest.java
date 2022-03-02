package com.ch.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-03-02 16:02
 */
public class FileInputOutStreamTest {

    @Test
    public void testFileInputStream()  {

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
                System.out.println(bbuff[len]);
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
}
