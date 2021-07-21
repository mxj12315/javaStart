package com.neiBuLei2;

/**
 * 继承静态内部类
 */
public class Nbl2 extends Out.In2 {
    // 构造函数默认会调用super()的无参数构造
    public void getFullName(){}

    public Nbl2(){
        // 下面是默认隐藏的
        super();
    }

    public static void main(String[] args) {

    }
}
