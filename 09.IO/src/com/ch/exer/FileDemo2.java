package com.ch.exer;

import org.junit.Test;

import java.io.File;

/**
 * 2.判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 *
 * @author chenpi
 * @create 2022-03-01 15:41
 */
public class FileDemo2 {
    @Test
    public void test() {
        File iodir2 = new File("iodir2");
        for (String s : iodir2.list()) {
            if (s.endsWith(".jpg")) {
                System.out.println(s);
            }
        }

    }
}
