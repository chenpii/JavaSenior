package com.ch.java;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * get 无参请求
 * @author chenpi
 * @create 2022-02-24 14:05
 */
public class HttpPostDemo {
    @Test
    public void test() {
        //可关闭的httpclient客户端，相当于打开的一个浏览器
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "https://www.baidu.com/";
        //构造httpget请求对象
        HttpGet httpGet = new HttpGet(urlStr);
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
            /**
             * HttpEntity 不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。
             */
            //获取响应结果
            HttpEntity entity = response.getEntity();
            //对HttpEntity操作的工具类
            String toStringResult = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(toStringResult);
            //确保流关闭
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
