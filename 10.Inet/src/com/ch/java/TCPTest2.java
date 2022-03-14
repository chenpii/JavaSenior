package com.ch.java;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送文件给服务端。服务端将文件保存到本地
 *
 * @author chenpi
 * @create 2022-03-14 10:00
 */
public class TCPTest2 {


    @Test
    public void client() {

        OutputStream ops = null;
        FileInputStream fis = null;

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8899);
            ops = socket.getOutputStream();

            fis = new FileInputStream("picture.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                ops.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ops != null)
                    ops.close();
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

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(8899);

            socket = ss.accept();
            is = socket.getInputStream();

            fos = new FileOutputStream("server_save.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("收到来自" + socket.getInetAddress().getHostAddress()+ "的文件");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
