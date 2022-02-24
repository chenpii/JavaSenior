package com.ch.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author chenpi
 * @create 2022-02-24 20:16
 */
public class HttpURLConnTest {
    /**
     * 使用jdk原生的api来请求网页
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String urlStr = "https://www.baidu.com/";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置请求类型
        /**
         *
         * 请求行
         * 空格
         * 请求头
         * 请求体
         *
         */

        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept-Charset","UTF-8");

        //获取httpURLConnection的输入流
        InputStream is = httpURLConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

    }
}
