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
}
