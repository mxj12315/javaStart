package com.minsusu;


/**
 * 初始化代码块
 *  类初始化代码块
 */
public class StaticInitTest {
    // 类初始化变量1
    static String name  = "王思聪";

    // 类初始化代码块
    static {
        name = "房祖名";
        name1 = "张学友";
    }

    // 类初始化变量2
    static String name1 = "刘德华";



    public static void main(String[] args) {

        // Q 类初始化代码块和初始化类变量谁在前谁在后？
        // A :顺序以源代码中的顺序相同

        System.out.println(name);  //"房祖名"
        System.out.println(name1);  //"刘德华"
    }
}
