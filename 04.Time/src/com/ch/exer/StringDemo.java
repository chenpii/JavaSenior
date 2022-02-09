package com.ch.exer;

import org.junit.Test;

/**
 * 将一个字符串进行反转。
 * 将字符串中指定部分进行反转。比如"abcdef"反转为"abfedc"
 * @author chenpi
 * @create 2021-12-19 18:56
 */
public class StringDemo {

    /*
    方式一：转换为char[]
     */

    public String reverse(String str, int startIndex, int endIndex) {

        if (str != null) {
            char[] chars = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = chars[x];
                chars[x] = chars[y];
                chars[y] = temp;
            }
            return new String(chars);
        }
        return null;
    }

    /*
    方式二：使用StringBuffer/StringBuilder
     */
    public String reverse2(String str, int startIndex, int endIndex) {

        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());

            //第一部分
            builder.append(str.substring(0, startIndex));

            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }

            //第三部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }


    @Test
    public void testReverse() {
        String str = "abcdef";
        String str2 = reverse(str, 2, 5);
        System.out.println(str);
        System.out.println(str2);
    }

    @Test
    public void testReverse2() {
        String str = "abcdef";
        String str2 = reverse2(str, 2, 5);
        System.out.println(str);
        System.out.println(str2);
    }

}
