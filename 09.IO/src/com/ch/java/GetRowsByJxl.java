package com.ch.java;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-03-03 13:35
 */
public class GetRowsByJxl {

    public static void main(String[] args) {
        String pathname = "E:\\Jmeter\\apache-jmeter-5.4.1\\bin\\data\\export\\套餐档案-2022-03-04.xls";
        System.out.println(getRowsByJxl(pathname));
    }

    public static int getRowsByJxl(String pathname) {
        Workbook workbook = null;
        int rows = 0;
        try {
            File xlsFile = new File(pathname);
            //获得工作簿对象
            workbook = Workbook.getWorkbook(xlsFile);
            Sheet sheet = workbook.getSheet(0);

            //总行数
            rows = sheet.getRows();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }
        return rows;
    }



}
