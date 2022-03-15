package com.ch.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author chenpi
 * @create 2022-03-15 18:30
 */
public class URLTest2 {

    public static void main(String[] args) {

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //获得URL对象
            URL url = new URL("http://localhost:8090/examples/cat.jpg");

            //获得对应的Connection对象,并连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            //获取输入流，并下载数据
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("cat.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("下载完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
