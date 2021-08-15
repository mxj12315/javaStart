package com.season;

/**
 * 枚举测试类
 */
public class SeasonTest {
    public static void main(String[] args) {
        // 枚举赋值，使用已有的实例进行赋值
        Season s1 = Season.SPRING;
        Season s3 = Season.AUTUMN;
        Season winter = Season.WINTER;
        System.out.println(s1);
        System.out.println(s3);
        System.out.println(winter);
        // 获取枚举的名字
        String name = s1.name();
        // 返回所有枚举实例
        Season[] arr = Season.values();
        for (Season s : arr) {
            s.info();
        }

        // 根据枚举名返回枚举实例
        Season season = Season.valueOf("SPRING");
        System.out.println("枚举的名字:" + name);

        System.out.println("根据枚举名返回枚举实例:" + season);
    }
}
