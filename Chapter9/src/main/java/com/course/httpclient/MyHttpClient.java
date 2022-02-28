package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        // 用来存放我们的结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        // 这个是用来执行get方法的
        // HttpClient client = new DefaultHttpClient();
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        // 获取响应的整体信息并转换成字符串
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        // 打印响应结果
        System.out.println(result);
    }
}
