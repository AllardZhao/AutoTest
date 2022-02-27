package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 执行！");
    }

    // 设置Test注释enabled属性值为False不执行该测试
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行！");
    }

    // Test注释当没设置enabled属性时值默认为True
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行！");
    }
}
