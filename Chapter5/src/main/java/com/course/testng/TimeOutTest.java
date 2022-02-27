package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    // 设置注解Test的timeOut超时属性值为3000ms
    // 期望在这个时间之内得到结果
    @Test(timeOut = 3000)   // 测试成功
    public void testSuccess() throws InterruptedException{
        // 等待2秒后就抛出异常
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)   // 测试失败
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
