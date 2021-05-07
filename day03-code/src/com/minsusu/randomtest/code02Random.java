package com.minsusu.randomtest;

import java.util.Random;
import java.util.Scanner;

/**
 * Random包
 * for循环猜数字改造版本
 */
public class code02Random {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(101);

        // 用户输入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 10; i++) {
            System.out.println("请输入一个1-100的数字:");
            int b = sc.nextInt();
            if (i==9) {
                System.out.println("机会用完了");
                break;
            }else {
                System.out.println("您还有"+(9-i)+"次机会");
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
}
