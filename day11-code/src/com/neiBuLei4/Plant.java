package com.neiBuLei4;

/**
 * Plant函数式接口，只有一个抽象方法的接口@FunctionalInterface
 */
@FunctionalInterface
public interface Plant {
    // 植物有颜色
    void color();


    // 静态方法
    static int sum(int a ,int b){
        return a+b;
    }

    default void test1(){
        System.out.println("HelloPlant");
    }
}
