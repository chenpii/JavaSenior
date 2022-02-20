package com.ch.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author chenpi
 * @create 2022-02-20 21:47
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = null;
        Properties pros = null;
        try {
            pros = new Properties();
            fis = new FileInputStream("myconfig.properties");
            pros.load(fis);//加载流对应的文件
            String name = pros.getProperty("name");
            System.out.println(name);

            String password = pros.getProperty("password");
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
