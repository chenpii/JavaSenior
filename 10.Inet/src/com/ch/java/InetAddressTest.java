package com.ch.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chenpi
 * @create 2022-03-11 10:45
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress inet1 = InetAddress.getByName("180.101.49.12");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getLocalHost();
        System.out.println(inet3);

        String hostName = inet1.getHostName();
        System.out.println(hostName);

        String hostAddress = inet1.getHostAddress();
        System.out.println(hostAddress);
    }
}
