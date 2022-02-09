package com.ch.exer;

import org.junit.Test;

/**
 * 获取两个字符串中的最大相同子串。
 * str1="abcwerthelloyuiodef";
 * str2="cvhellobnm"
 *
 * @author chenpi
 * @create 2021-12-19 21:26
 */
public class StringDemo3 {
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++,y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(getMaxSameString(str1, str2));
    }
}
