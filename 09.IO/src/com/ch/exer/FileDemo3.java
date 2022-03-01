package com.ch.exer;

import org.junit.Test;

import java.io.File;

/**
 * 3.遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 3.1并计算指定目录占用空间的大小
 * 3.2删除指定文件目录及其下的所有文件。
 *
 * @author chenpi
 * @create 2022-03-01 15:42
 */
public class FileDemo3 {

    @Test
    public void test() {
        File iodir3 = new File("iodir3");
        showAll(iodir3);
        System.out.println(getSizeAll(iodir3));
    }


    /**
     * 显示file下所有的文件
     *
     * @param file
     */
    public void showAll(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                showAll(f);
            } else {
                System.out.println(f);
            }
        }
    }

    /**
     * 计算file目录大小
     * @param file
     * @return
     */
    public long getSizeAll(File file) {
        File[] files = file.listFiles();
        long size = 0;
        for (File f : files) {
            if (f.isDirectory()) {
                getSizeAll(f);
            } else {
                size += f.length();
                System.out.println(f);
            }
        }
        return size;
    }

}
