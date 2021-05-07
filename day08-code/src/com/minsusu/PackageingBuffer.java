package com.minsusu;

/**
 * 包装类的缓冲
 */
public class PackageingBuffer {
    public static void main(String[] args) {
        Integer i = 20;   // -128~127范围内会有缓冲
        Integer j = 20;

        Integer k = 200;  // 不在-128~127范围内不会有缓冲
        Integer l = 200;

        System.out.println(i==j);   //true
        System.out.println(k==l);  //false
    }
}
