package com.minsusu.packaging;

public class Packaging {
    private String name;
    private int age;

    // 构造函数
    public Packaging(){}

    // 构造器有参数
    public Packaging(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()<9 || name.length()<4){
            System.out.println("名字应该在4~9位："+name);
            return;
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<18  || age >80){
            System.out.println("年龄应该在18~80岁之间："+age);
            return;
        }
        this.age = age;
    }
}
