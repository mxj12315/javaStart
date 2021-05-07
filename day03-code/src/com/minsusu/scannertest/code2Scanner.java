package com.minsusu.scannertest;

import java.util.Scanner;

public class code2Scanner {
    public static void main(String[] args) {
        // 获取用户输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字");
        int b = sc.nextInt();
        int max = getMax(a,b);
        System.out.println("最大值是"+max);
    }

    public static int getMax(int num1, int num2){
        if (num1>num2){
            return num1;
        }else if (num1<num2){
            return num2;
        }else {
            return num2;
        }
    }
}
