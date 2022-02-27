package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
        // 抛出一个显性异常
        throw new RuntimeException();
    }

    // 设置test2依赖test1，dependsOnMethods为依赖属性
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }

}
