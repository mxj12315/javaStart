package com.maptest;

import java.util.HashMap;


/**
 * 没有重写equals()和hashCode()
 */
public class HashMapTest1 {
    private String color;
    private double weight;

    public HashMapTest1(){

    }

    public HashMapTest1(String color,double weight){
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Apple=[color = " + this.color + "],[weight = "+ this.weight + "]";
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


    public static void main(String[] args) {
        HashMapTest1 hashMapTest1 = new HashMapTest1("红色",12.5);
        HashMapTest1 hashMapTest2 = new HashMapTest1("绿色",11.0);
        HashMapTest1 hashMapTest3 = new HashMapTest1("黄色",12.5);
        HashMapTest1 hashMapTest4 = new HashMapTest1("红色", 12.5);



        // 新建一个HashMap集合
        HashMap<HashMapTest1,String> hm = new HashMap<>();
        hm.put(hashMapTest1,"Red Apple1");
        hm.put(hashMapTest2,"Green Apple");
        hm.put(hashMapTest3,"Yellow Apple");
        hm.put(hashMapTest4,"Red Apple2");

        System.out.println(hm);

    }
}
