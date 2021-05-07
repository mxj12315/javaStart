package com.minsusu.equalsTest;

import java.util.Objects;

/**
 * 山羊类
 */
public class Goat {
    String color;
    double weight;

    public Goat(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        // 比较内存地址，如果是同一个内存地址，返回true
        if (this == o) return true;
        // 如果比较的对象为空，且被比较的对象o必须是同一个类型，则返回false
        if (o == null || getClass() != o.getClass()) return false;
        // 经过上面过滤，进行强制类型转换
        Goat goat = (Goat) o;
        // 自定义的相等规则
        return this.color.equals(goat.color) && this.weight == goat.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight);
    }

    @Override
    public String toString() {
        return "Goat{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
