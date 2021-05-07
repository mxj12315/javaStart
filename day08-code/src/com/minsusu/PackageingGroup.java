package com.minsusu;


/**
 * 包装类
 */
public class PackageingGroup {
    public static void main(String[] args) {

        Integer in = 20;  // 自动装箱
        Object  o  = 3.2F;  // 自动装箱,向上转型
        Long l = 23L;
        System.out.println(in*l);

        String str = "123456a";
        System.out.println(Integer.parseInt(str));
    }
}
