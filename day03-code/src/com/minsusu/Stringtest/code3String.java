package com.minsusu.Stringtest;


import java.util.Scanner;

/**
 * String类创建出来不可以改变，属于常量，可以共享
 * 获取键盘输入，并且统计各自出现的次数
 */
public class code3String {
    public static void main(String[] args) {
        // 获取用户输入
        Scanner sc = new Scanner(System.in);
        // 提示用户输入
        System.out.print("请输入任意内容：");
        String str = sc.next();
        System.out.println("用户输入的内容是：" + str);
        String result = getUserInput(str);
        System.out.println(result);
    }

    public static String getUserInput(String str) {
        // 定义计数变量
        int numCount = 0;  // 数字计数器
        int upperStrCount = 0;  // 大写字母计数器
        int lowerStrCount = 0;  // 小写字母计数器
        int otherCount = 0;  // 其他种类的计数器
        // 转化为字符数组
        char[] chars = str.toCharArray();
        for (char charItem : chars) {
            // 判断,利用char类型参与计算会提升为int类型
            if (charItem >= 'a' && charItem <= 'z') {
                // 是小写字母
                lowerStrCount++;
            } else if (charItem >= 'A' && charItem <= 'Z') {
                // 是大写字母
                upperStrCount++;
            } else if (charItem >= '0' && charItem <= '9') {
                // 是字母
                numCount++;
            } else {
                // 是其他的
                otherCount++;
            }
        }

        return "\n" + "数字的个数是：" + numCount + "\n"
                + "小写字母的个数是：" + lowerStrCount + "\n"
                + "大写字母的个数是：" + upperStrCount + "\n"
                + "其他字母的个数是：" + otherCount + "\n"
                + "输入总长度是：" + chars.length;
    }
}
