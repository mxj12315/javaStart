package com.treeMapTest;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap定制排序
 */
public class TreeMapTest2 {
    public static void main(String[] args) {
        // TreeMap比较大小，比较Key,要么自然排序，要么定制排序
        // 如果没有实现，则抛出 className cannot be cast to java.lang.Comparable
        // Apple要么实现Comparable接口的compareTo方法，使用自然排序比较大小
        // Apple要么创建时候传入Comparator对象，进行自定义排序
        Map<Apple, Integer> treeMap = new TreeMap<>(new Comparator<Apple>() {
            /*
            如果当前对象大于要比较的对象，返回正整数
            如果当前对象小于要比较的对象，返回负整数
            如果当前对象等于要比较的对象，返回0
             */
            @Override
            public int compare(Apple o1, Apple o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        treeMap.put(new Apple("红色", 12.1), 10);
        treeMap.put(new Apple("绿色", 12.3), 8);
        treeMap.put(new Apple("黄色", 11.1), 5);
        treeMap.put(new Apple("紫色", 13.8), 22);


        System.out.println(treeMap);  //  {Apple{color='黄色', weight=11.1}=5, Apple{color='红色', weight=12.1}=10, Apple{color='绿色', weight=12.3}=8, Apple{color='紫色', weight=13.8}=22}
    }
}


class Apple {
    private String color;
    private double weight;

    public Apple() {

    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}