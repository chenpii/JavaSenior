package com.ch.java;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-03-04 14:05
 */
public class GetRowsByPoi {
    public static void main(String[] args) {
        String pathname = "E:\\Jmeter\\apache-jmeter-5.4.1\\bin\\data\\export\\套餐档案-2022-03-04.xls";

        System.out.println(getRowsByPoi(pathname));
    }

    public static int getRowsByPoi(String pathname) {

        Workbook workbook = null;
        int rows = 0;
        try {
            File xlsFile = new File(pathname);
            //获得工作簿对象
            workbook = WorkbookFactory.create(xlsFile);
            Sheet sheet = workbook.getSheetAt(0);
            //总行数
            rows = sheet.getPhysicalNumberOfRows();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null)
                    workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }
}
