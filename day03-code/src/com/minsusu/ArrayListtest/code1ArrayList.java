package com.minsusu.ArrayListtest;

import java.util.ArrayList;

/**
 * ArrayList集合
 */
public class code1ArrayList {
    public static void  main(String[] args){
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println(list1.size());
        // 添加
        list1.add("马云");
        list1.add("刘强东");
        list1.add("马化腾");
        System.out.println(list1); //[马云, 刘强东, 马化腾]
        System.out.println(list1.size());  // 3

        // 获取索引对应的元素
        String str = list1.get(2); // 获取索引2的值
        System.out.println(str);  // 马化腾,

        // 移除元素
        list1.remove("马云");
        System.out.println(list1);  // 马化腾,


        // 指定位置添加
        list1.add(1,"王健林");
        System.out.println(list1);
    }
}
