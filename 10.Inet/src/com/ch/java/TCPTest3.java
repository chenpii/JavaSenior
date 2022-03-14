package com.ch.java;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端。并关闭相应的连接
 *
 * @author chenpi
 * @create 2022-03-14 10:38
 */
public class TCPTest3 {

    @Test
    public void client() {

        OutputStream ops = null;
        FileInputStream fis = null;
        Socket socket = null;
        ByteArrayOutputStream baos = null;

        try {
            //创建socket对象
            socket = new Socket("127.0.0.1", 8899);

            //获取输出流
            ops = socket.getOutputStream();
            fis = new FileInputStream("picture.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                ops.write(buffer, 0, len);
            }

            //关闭数据的传输
            socket.shutdownOutput();
            //接受来自服务端的信息，打印在控制台
            InputStream ips = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[20];
            len = 0;
            while ((len = ips.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭资源
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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

        OutputStream ops = null;
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

            System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的文件");

            //服务端给客户端反馈
            ops = socket.getOutputStream();
            ops.write(new String("谢谢，文件已收到").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
