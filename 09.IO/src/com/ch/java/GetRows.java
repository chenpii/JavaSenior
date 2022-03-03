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
public class GetRows {

    public static void main(String[] args) {
        System.out.println(getRows("E:\\Jmeter\\apache-jmeter-5.4.1\\bin\\data\\export\\套餐档案-2022-03-03.xls"));

    }

    public static int getRows(String pathname) {
        Workbook workbook = null;
        int rows = 0;
        try {
            File xlsFile = new File(pathname);
            //获得工作簿对象
            workbook = Workbook.getWorkbook(xlsFile);
            Sheet sheet = workbook.getSheet(0);
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

    public static int getRightRows(String pathname){
        Workbook workbook = null;
        int rows = 0;
        try {
            File xlsFile = new File(pathname);
            //获得工作簿对象
            workbook = Workbook.getWorkbook(xlsFile);
            Sheet sheet = workbook.getSheet(0);
            int rsCols = sheet.getColumns(); // 列数
            int rsRows = sheet.getRows(); // 行数
            int nullCellNum;
            int afterRows = rsRows;
            for (int i = 1; i < rsRows; i++) { // 统计行中为空的单元格数
                nullCellNum = 0;
                for (int j = 0; j < rsCols; j++) {
                    String val = sheet.getCell(j, i).getContents();
//                    val = StringUtils.trimToEmpty(val);
//                    if (StringUtils.isBlank(val))
                        nullCellNum++;
                }
                if (nullCellNum >= rsCols) { // 如果nullCellNum大于或等于总的列数
                    afterRows--; // 行数减一
                }
            }
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
