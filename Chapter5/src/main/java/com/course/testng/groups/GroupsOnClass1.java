package com.course.testng.groups;

import org.testng.annotations.Test;

// Test注释不写在方法上，而是把它写在类上
@Test(groups = "Student")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("GroupsOnClass111中的student111运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass111中的student222运行");
    }
}