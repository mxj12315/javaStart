package com.minsusu.override;

public class Dog extends Animal{

    @java.lang.Override
    public void run() {
        System.out.println("小狗跳着跑");
    }


    public void eat(){
        System.out.println("小狗吃骨头");
    }
}
