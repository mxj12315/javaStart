package com.neiBuLei2;

public class Nbl {
    public static void main(String[] args) {
        // 1、在外部类以外使用静态内部类
        // 定义变量
        Out.In2 in;
        // 使用静态内部类的类变量
        int number = Out.In2.number;
        // 使用静态内部类的类方法
        String fullName = Out.In2.name("min","xingjing");
        System.out.println("静态内部类的类变量number："+number);
        System.out.println("静态内部类的类方法name："+fullName);

        // 使用静态内部类的成员变量
        Out.In2 in2 = new Out.In2();  // 创建实例
        int[] arr = in2.arr;  // 调用静态内部类的成员变量
        int item = in2.array(arr);  // 调用静态内部类的成员方法
        String toStr = in2.toString();  // 调用静态内部类的成员方法toString()
        System.out.println("静态内部类的实例变量arr："+arr);
        System.out.println("静态内部类的实例变量array："+item);
        System.out.println("静态内部类的实例变量toString："+toStr);

        System.out.println("/***************************************/");
        // 2、在外部类以外使用非静态内部类
        // a 调用非静态内部类的成员方法
        // 声明变量
        Out.In1 in1;
        Out out;
        out = new Out();
        in1 =out.new In1();// 创建实例
        // 获取非静态内部类的成员变量
        String in1str = in1.In1FistName; // 获取非静态内部类的成员变量
        double price = in1.price; // 获取非静态内部类的成员变量
        // 调用非静态内部类的成员方法
        int result = in1.sum(1,6);
        // b 获取非静态内部类的静态常量
        char ch = Out.In1.hz;

        System.out.println("非静态内部类的成员变量In1FistName："+in1str);
        System.out.println("非静态内部类的成员变量price："+price);
        System.out.println("非静态内部类的成员方法sum："+result);
        System.out.println("非静态内部类的类变量："+ch);




    }
}
