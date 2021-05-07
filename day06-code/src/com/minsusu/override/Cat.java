package com.minsusu.override;

public class Cat extends Animal{


    // Override:用于提示重写方法是否正确
    @java.lang.Override
    public void run(){
        System.out.println("猫轻轻的跑");
    }
}
