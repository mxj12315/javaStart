package com.neiBuLei3;

/**
 * Animal抽象类
 */
public abstract class   Animal {
    public abstract void run();
    public abstract void eat();
    public  void jump(){
        System.out.println("动物能跳跃");
    };

    public Animal(){

    }
    public Animal(String name){
        System.out.println(name);
    }

}
