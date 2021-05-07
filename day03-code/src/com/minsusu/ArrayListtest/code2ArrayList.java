package com.minsusu.ArrayListtest;

import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList集合
 * 存储随机数,帅选出偶数
 */
public class code2ArrayList {
    public static void  main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
           int a =  r.nextInt(20);
            list1.add(a);
        }
        System.out.println(list1);
        System.out.println("--------------");
        ArrayList<Integer> smallList =  getSmallList(list1);
        System.out.println("小集合的长度是："+smallList.size());
        for (int i = 0; i < smallList.size(); i++) {
            System.out.println(smallList.get(i));
        }

    }

    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smallList = new ArrayList<>();
        System.out.println("大集合的长度是："+list.size());
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 == 0){
                // 是偶数
                smallList.add(num);
            }
        }

        return smallList;
    }
}
