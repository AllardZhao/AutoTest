package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    // 给方法加上参数化注解Parameters
    @Parameters({"name", "age"})
    public void parameterTest1(String name, int age){
        System.out.println("name = " + name + "; age = " + age);
    }
}