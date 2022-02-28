package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle; // 用来读取配置文件
    private CookieStore store;  //用来存储cookies信息

    // 在测试之前读取application.properties内容
    @BeforeTest
    public void beforeTest(){
        // 该方法默认识别properties文件，直接写配置文件名就行
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    // 测试方法
    @Test
    public void testGetCookies() throws IOException {
        String result,result2;
        // 从配置文件中读取信息，拼接测试的URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        // 测试逻辑代码1
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        // 获取Cookies信息
        this.store = new BasicCookieStore();
        CloseableHttpClient httpClient =HttpClients.custom().setDefaultCookieStore(store).build();
        // 测试逻辑
        HttpGet get2 = new HttpGet(testUrl);
        CloseableHttpResponse response2 = httpClient.execute(get2);
        //打印返回值
        result2 = EntityUtils.toString(response2.getEntity(), "utf-8");
        System.out.println(result2);

        //读取cookie信息
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie: cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name = " + name);
            System.out.println("cookie value = " + value);
        }

    }

    // 添加关联依赖
    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException {
        String uri =bundle.getString("get.with.cookies");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
//        DefaultHttpClient client = new DefaultHttpClient();
//        // 设置Cookies信息
//        client.setCookieStore(this.store);
//        HttpResponse response = client.execute(get);
//        //以上是获取响应的状态码
//        int statusCode = response.getStatusLine().getStatusCode();
//        if (statusCode == 200){
//            result = EntityUtils.toString(response.getEntity(), "utf-8");
//            System.out.println(result);
//        }
    }

}
