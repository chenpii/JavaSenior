package com.ch.exer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 计算文本文件中字符出现的频率
 *
 * @author chenpi
 * @create 2022-03-03 10:26
 */
public class WordCount {
    @Test
    public void test() {
        BufferedReader br = null;
        Map<Character, Integer> map = null;
        try {
            FileReader fr = new FileReader("hello.txt");
            br = new BufferedReader(fr);

            char[] cbuf = new char[1024];
            int len;
            map = new HashMap<Character, Integer>();

            while ((len = br.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    if (map.containsKey(cbuf[i])) {
                        map.put(cbuf[i], map.get(cbuf[i]) + 1);
                    } else {
                        map.put(cbuf[i], 1);
                    }
                }
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
        System.out.println(map);
    }
}
