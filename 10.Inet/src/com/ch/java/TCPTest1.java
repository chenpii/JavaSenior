package com.ch.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @author chenpi
 * @create 2022-03-11 17:02
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");

            socket = new Socket(inet, 8899);
            os = socket.getOutputStream();
            os.write("你好我是客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //服务端
    @Test
    public void server() {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bao = null;
        try {
            ServerSocket ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();

            //不建议使用，可能会乱码
//            byte[] buffer = new byte[20];
//            int len;
//            while ((len = is.read(buffer)) != -1) {
//                System.out.println(new String(buffer, 0, len));
//            }

            bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bao.write(buffer, 0, len);
            }

            System.out.println(bao.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bao.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
