package com.maptest;

import java.util.HashMap;

/**
 * 重写equals()和hashCode()
 */
public class HashMapTest2 {
    private String color;
    private double weight;

    public HashMapTest2() {

    }

    public HashMapTest2(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public static void main(String[] args) {
        HashMapTest2 hashMapTest1 = new HashMapTest2("红色", 12.5);
        HashMapTest2 hashMapTest2 = new HashMapTest2("绿色", 11.0);
        HashMapTest2 hashMapTest3 = new HashMapTest2("黄色", 12.5);
        HashMapTest2 hashMapTest4 = new HashMapTest2("红色", 12.5);

        // 新建一个HashMap集合
        HashMap<HashMapTest2, String> hm = new HashMap<>();
        hm.put(hashMapTest1, "Red Apple1");
        hm.put(hashMapTest2, "Green Apple");
        hm.put(hashMapTest3, "Yellow Apple");
        hm.put(hashMapTest4, "Red Apple2");

        System.out.println(hm);

    }

    @Override
    public String toString() {
        return "Apple={[color = " + this.color + "],[weight = " + this.weight + "]}";
    }

    /**
     * 重写equals方法
     *
     * @param target 要比较的对象
     * @return 重量相同 颜色相同都认为是相等的
     */
    @Override
    public boolean equals(Object target) {
        // 如果实例和比较对象的内存地址相同则表示同一个对象
        if (this == target) return true;
        // 如果两个的类相同
        if (target != null && target.getClass() == HashMapTest2.class) {
            // 进行类型转换
            HashMapTest2 h = (HashMapTest2) target;
            return h.color.equals(this.color) && (h.weight - this.weight) < 10e-6;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int Prime = 31;
        return this.color.hashCode() * Prime + (int) this.weight;
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
}
