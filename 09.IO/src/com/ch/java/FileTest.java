package com.ch.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称文件夹）
 * 2.File声明在java.io包下
 * 3.路径分隔符
 *
 * @author chenpi
 * @create 2022-02-28 22:31
 */
public class FileTest {


    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module
        File file2 = new File("E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\he.txt");

//        File file3 = new File("E:" + File.separator + "developerde" + File.separator + "workspace" + File.separator + "JavaSenior" + File.separator + "09.IO" + File.separator + "he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:\\developer\\idea\\workspace", "JavaSenior");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

    }

    /**
     * public String getAbsolutePath()：获取绝对路径。
     * public String getPath()：获取路径。
     * public String getName()：获取名称。
     * public String getParent()：获取上层文件目录路径。若无，返回null。
     * public long length()：获取文件长度（字节数）。不能获取目录的长度。
     * public long lastModified()：获取最后一次的修改时间，毫秒值。
     * <p>
     * 如下的两个方法适用于文件目录
     * public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组。
     * public File[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组。
     */
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\developer\\idea\\workspace\\JavaSenior\\09.IO\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

    }

    @Test
    public void test3() {
        File file1 = new File("E:\\developer\\idea\\workspace\\JavaSenior");
        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] listFiles = file1.listFiles();
        for (File f : listFiles) {
            System.out.println(f);
        }

    }

    /**
     * public boolean renameTo(File dest)：把文件重命名为指定的文件路径。
     * <p>
     * 比如file1.renameTo(file2)
     * 要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */
    @Test
    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /**
     * public boolean isDirectory()：判断是否是文件夹。
     * public boolean isFile()：判断是否是文件。
     * public boolean exists()：判断是否存在。
     * public boolean canRead() ：判断是否可读。
     * public boolean canWrite() ：判断是否可写。
     * public boolean isHidden() ：判断是否隐藏。
     */
    @Test
    public void test5() {
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());


        System.out.println();
        File file2 = new File("E:\\developer\\idea\\workspace\\JavaSenior\\09.IO");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /**
     * 创建硬盘中对应的文件或文件目录
     * public boolean createNewFile()：创建文件。若文件存在，则不创建，返回false。
     * public boolean mkdir()：创建文件目录。如果此文件目录存在，就不创建。如果此文件目录的上层目录不存在，也不创建。
     * public boolean mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建。
     * <p>
     * 删除硬盘中的文件或文件目录
     * public boolean delete()：删除文件或者文件夹。
     */

    @Test
    public void test6() throws IOException {

        //文件的创建
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else {
            file1.delete();
            System.out.println("删除成功");
        }


    }

    @Test
    public void test7() {
        File file = new File("E:\\developer\\io1\\io3");
        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println("创建成功1");
        }


        File file2 = new File("E:\\developer\\io\\io2\\io3");
        boolean mkdir2 = file2.mkdirs();
        if (mkdir2) {
            System.out.println("创建成功2");
        }
    }

}
