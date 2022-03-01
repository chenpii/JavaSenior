package com.ch.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1.利用File构造器，new一个文件目录file
 * 在其中创建多个文件和目录
 * 编写方法，实现删除file中指定文件的操作
 *
 * @author chenpi
 * @create 2022-02-28 23:58
 */
public class FileDemo1 {
    @Test
    public void test1() throws IOException {
        File file = new File("iodir1");
        if (file.createNewFile()) {
            System.out.println("目录创建成功");
        }
        File file1 = new File(file, "hello.txt");
        File dir1 = new File(file, "newDir");
        boolean b = file1.createNewFile();
        if (b) {
            System.out.println("子文件创建成功");
        }
        boolean b1 = dir1.mkdirs();
        if (b1) {
            System.out.println("子目录创建成功");
        }

        deleteFile(file1);
        deleteFile(dir1);

    }

    public void deleteFile(File file) {
        if (file.delete()) {
            System.out.println(file + "删除成功");
        }
    }
}
