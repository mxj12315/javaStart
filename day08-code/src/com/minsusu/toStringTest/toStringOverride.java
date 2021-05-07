package com.minsusu.toStringTest;

/**
 * 重写同string方法
 */
public class toStringOverride {
    public static void main(String[] args) {
        Apple apple1 = new Apple("红色",3.2);
        Apple apple2 = new Apple("白色",2.2);
        Apple apple3 = new Apple("绿色",5.0);

        System.out.println(apple1);
        System.out.println(apple2);
        System.out.println(apple3);

    }
}
