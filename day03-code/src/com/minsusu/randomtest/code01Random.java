package com.minsusu.randomtest;

import java.util.Random;
import java.util.Scanner;

/**
 * Random包
 */
public class code01Random {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(11);

        // 用户输入
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个1-10的数字:");
            int b = sc.nextInt();
            if (b == a){
                System.out.println("猜对了");
                break;
            }else if (b > a){
                System.out.println("猜大了");
            }else {
                System.out.println("猜小了");
            }
        }




    }
}
