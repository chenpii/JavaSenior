package com.ch.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流
 * 1.标准的输入输出流
 * 2.打印流
 * 3.数据流
 *
 * @author chenpi
 * @create 2022-03-03 22:36
 */
public class OtherStreamTest {
    /**
     * 1.标准的输入输出流
     * <p>
     * 1.3练习
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     * <p>
     * 方法一：使用Scanner实现。
     * 方法二：使用System.in实现。System.in ---> 转换流 -->BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束！");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 2.打印流 PrinterStream、PrinterWriter
     *
     */

}
