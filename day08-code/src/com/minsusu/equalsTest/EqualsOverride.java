package com.minsusu.equalsTest;

public class EqualsOverride {

    public static void main(String[] args) {
        Goat goat1 = new Goat("黑色",81.0);
        Goat goat2 = new Goat("黑色",81.0);
        // 使用"==",比较内存地址
        System.out.println(goat1 == goat2 );  // false
        // 使用重写的equals方法比较
        System.out.println(goat1.equals(goat2));  //true
    }
}
