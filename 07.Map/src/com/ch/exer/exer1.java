package com.ch.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * 从键盘随机输入10个整数保存到List中，并按照倒序、从大到小的顺序显示出来。
 * @author chenpi
 * @create 2022-02-21 15:00
 */
public class exer1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(scanner.nextInt());
        }
        //倒序
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //从大到小
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }
}
