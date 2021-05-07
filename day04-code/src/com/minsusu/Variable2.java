package com.minsusu;

public class Variable2 {
    int a;  // 实例变量
    static int b;  // 类变量
    public static void main(String[] args) {
        // 访问实例变量
        Variable2 v = new Variable2();
        System.out.println("实例变量a:"+v.a);  // 实例变量a:0


        // 访问类变量
        System.out.println("类变量b:"+b);  // 类变量b:0

    }
}
