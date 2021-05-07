package com.minsusu.randomtest;

import java.util.Random;


/**
 * Random包
 * nextInt(取值范围)左闭右开
 * 随机获取验证码
 */
public class code03Random {
    public static void main(String[] args) {
        Random random = new Random();
        char[] chars = new char[4];
        for (int i=0; i<chars.length;i++){
            // 小写字母 97~97+25
            int r = random.nextInt(26)  + 97;
            char c = (char) r;  // 强制转换为char类型
            chars[i] = c;
        }
        String str = new String(chars);
        System.out.println(str);
        String str1 = chars.toString();
        System.out.println(str1);
    }
}
