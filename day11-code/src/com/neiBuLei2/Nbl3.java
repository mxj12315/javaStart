package com.neiBuLei2;

public class Nbl3 extends Out.In1{
    public Nbl3() {
        // 宿主.super（）
        new Out().super();
    }


    // 传递一个参数，类型为内部类的宿主
    public Nbl3(Out out) {
        // 宿主.super（）
        out.super();
    }

    public static void main(String[] args) {

    }
}
