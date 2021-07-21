package com.LambdaFn;

public class Lambda1 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn fn = str -> str.length();
        int length = fn.getLenght("zhang");
        System.out.println(length);

        //  进一步简化的Lambda表达式  某个类::某个方法
        Fn fn1 = String::length;
        System.out.println(fn1.getLenght("MINXINGJING"));

    }
}
