package com.ch.java;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author chenpi
 * @create 2022-03-14 15:52
 */
public class UDPTest1 {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = new String("我是UDP方式发送的数据");
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 8989);

        socket.send(packet);


    }

    //接收端
    @Test
    public void reveiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(8989);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();


    }
}
