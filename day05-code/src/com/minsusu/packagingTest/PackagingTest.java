package com.minsusu.packagingTest;

import com.minsusu.packaging.Packaging;

public class PackagingTest {
    public static void main(String[] args){
        // 无参数构造器
        Packaging p  =new Packaging();
        p.setName("nmj");  // 名字应该在4~9位：nmj
        String name = p.getName();
        System.out.println(name);   //null


        p.setAge(18);
        int age = p.getAge();
        System.out.println(age); //18


        // 有参数构造器
        Packaging p1 =new Packaging("张三",29);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());

    }
}
