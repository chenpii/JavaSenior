package com.ch.java;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chenpi
 * @create 2022-03-15 9:23
 */
public class URLTest1 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://127.0.0.1:8080/examples/servlets/cat.jpg");
//            String getProtocol()	获取URL的协议名
            System.out.println(url.getProtocol());
//            String getHost()	获取URL的主机名
            System.out.println(url.getHost());
//            int getPort()	获取URL的端口号
            System.out.println(url.getPort());
//            String getPath()	获取URL的文件路径
            System.out.println(url.getPath());
//            String getFile()	获取URL的文件名
            System.out.println(url.getFile());
//            String getQuery()	获取URL的查询名
            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
