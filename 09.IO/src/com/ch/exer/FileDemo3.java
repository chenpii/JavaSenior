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

        File dir = new File("iodir3\\conf\\nacos");
        removeAll(dir);
    }


    /**
     * 显示file下所有的文件
     *
     * @param file
     */
    public void showAll(File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                showAll(listFile);
            } else {
                System.out.println(listFile);
            }
        }

    }

    /**
     * 计算file目录大小
     *
     * @param file
     * @return
     */
    public long getSizeAll(File file) {
        long size = 0;
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                size += getSizeAll(listFile);
            } else {
                size += listFile.length();
            }
        }
        return size;
    }

    /**
     * 删除指定目录
     *
     * @param file
     */
    public void removeAll(File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {//删除子目录
                removeAll(listFile);
            } else {
                listFile.delete();//删除文件
            }

        }
        file.delete();//删除目录本身
    }

}
