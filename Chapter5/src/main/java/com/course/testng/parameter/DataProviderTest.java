package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    // 设置dataProvider属性进行参数化,值为数据来源DataProvider中设置name值
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name = " + name + "; age = " + age);
    }

    // 参数化数据来源，会将该方法的数据传到testDataProvider里
    @DataProvider(name="data")
    public Object [][] providerData(){
        Object [][] o = new Object[][]{
                {"张三", 10},
                {"李四", 20},
                {"王五", 30}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("test1方法 name="+name+"; age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("test2方法 name="+name+"; age="+age);
    }

    // 根据不同的方法名传递不同参数
    @DataProvider(name="methodData")
    public Object [][] methodDataTest(Method method){
        Object [][] result = null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"张三", 20},
                    {"李四", 25}
            };
        }
        else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"王五", 50},
                    {"柳六", 60}
            };
        }
        return result;
    }

}

