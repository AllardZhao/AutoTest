package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {

    // 设置Test注释invocationCount属性值为5，threadPoolSize属性值为3
    // invocationCount执行次数，threadPoolSize为线程池内的线程个数
    @Test(invocationCount = 5, threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        // 打印当前线程ID
        System.out.printf(
                "Thread ID: %s%n",
                Thread.currentThread().getId());
    }
}