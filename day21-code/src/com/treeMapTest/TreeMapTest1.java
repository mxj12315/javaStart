package com.treeMapTest;


import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap自然排序
 */
public class TreeMapTest1 {
    public static void main(String[] args) {
        // String类已经实现了Comparable接口，String类本身就可以比较大小，规则先第一个字母，在比较第二个字母
        Map<String, Double> treeMap = new TreeMap<>();
        treeMap.put("java",90.1);
        treeMap.put("python",89.0);
        treeMap.put("html",73.2);
        treeMap.put("javascript",60.9);

        System.out.println(treeMap);  //  {html=73.2, java=90.1, javascript=60.9, python=89.0}
    }
}
