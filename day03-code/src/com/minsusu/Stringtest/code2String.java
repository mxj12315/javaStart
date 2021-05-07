package com.minsusu.Stringtest;


/**
 * String类创建出来不可以改变，属于常量，可以共享
 * 按照指定的格式输出字符串,输出格式为[word#word#word]
 */
public class code2String {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,5,6,9,7,8};
        String format =  getFormatStr(list);
        System.out.println(format);  //[1#2#3#5#6#9#7#8]
    }

    public static String getFormatStr(int[] list){
        String str ="[";
        for (int i = 0; i < list.length; i++) {
            // 如果是最后一个
            if (i == list.length - 1){
                str+="word"+list[i]+"]";
            }else{
                str+="word"+list[i]+"#";
            }
        }
        return str;
    }
}
