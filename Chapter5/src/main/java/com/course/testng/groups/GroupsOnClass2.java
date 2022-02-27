package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "Student")
public class GroupsOnClass2 {
    public void stu3(){
        System.out.println("GroupsOnClass222中的student333运行");
    }
    public void stu4(){
        System.out.println("GroupsOnClass222中的student444运行");
    }
}