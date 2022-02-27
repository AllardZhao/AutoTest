package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "Teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("GroupsOnClass333中的teacher11运行");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass333中的teacher22运行");
    }
}