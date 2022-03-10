package com.ch.java1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-03-10 19:59
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srtfile = new File("09.IO\\photomode.png");
        File destfile = new File("09.IO\\photomode2.png");
        try {
            FileUtils.copyFile(srtfile,destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
