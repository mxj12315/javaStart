package com.minsusu.Stringtest;


/**
 * String类创建出来不可以改变，属于常量，可以共享
 * String str = "Hello"  存储的是字符串的地址值，可改变地址值但是字符串本身不能改变
 * 使用 == 判断地址值
 */
public class code1String {
    public static void main(String[] args) {
        // 创建空白字符串
        String str = new String();
        System.out.println("第一个字符串："+str);

        // 使用char类型的数组创建字符串
        String str1 = new String(new char[]{'A','B','C'});
        System.out.println("第二个字符串："+str1);

        // 使用byte类型的数组创建字符串
        String str2 = new String(new byte[]{97,98,99});
        System.out.println("第三个字符串："+str2);


        // 直接使用字面值
        String str3 = "Hello";
        System.out.println(str3);


        // 比较地址值
        String str4 = new String(new char[]{'J','A','V','A'});  // 不放在常量池中
        String str5 ="JAVA";  // 放在常量池
        // 使用 == 比较地址值
        System.out.println(str4 == str5);  // false
        // 使用equals比较内容，只适用于字符串
        System.out.println(str4.equals(str5));  //true


        System.out.println("------------获取字符串的长度----------------");
        // 获取字符串的长度
        String str6 = "sasdagsgsdvcxzvdvf4545sdfd";
        String str7 = "DSSG";
        System.out.println("str6字符串的长度"+str6.length());

        System.out.println("------------连接字符串,原来的字符串不会被改变----------------");
        // 连接字符串,原来的字符串不会被改变
        String str8 = str6.concat(str7);
        System.out.println("str6:"+str6);
        System.out.println("str7:"+str7);
        System.out.println("str8:"+str8);

        System.out.println("------------获取指定索引处的字符----------------");
        // 获取指定索引处的字符
        String str9 = "中华人民共和国";
        char ch = str9.charAt(2);
        System.out.println("["+str9+ "]字符串的第三个字符是："+ch);

        System.out.println("------------找到字符串中指定字符的首次出现的索引----------------");
        String str10 = "中华人民共和国中华人民共和国";
        // 找到字符串中指定字符的首次出现的索引indexOf(),找到返回索引，找不到返回-1
        int index = str10.indexOf('民');
        System.out.println("【民】所在的索引是"+index); // 3
        int index1 = str10.indexOf('我');
        System.out.println("【我】所在的索引是"+index1);  // -1

        System.out.println("------------ 字符串截取substring() 左闭右开----------------");
        // 字符串截取substring() 左闭右开
        String str11 ="HelloWorld";
        String str12 = str11.substring(5);
        String str13 = str11.substring(5,8);
        System.out.println("str11:"+str11);
        System.out.println("str12:"+str12);
        System.out.println("str13:"+str13);

        System.out.println("------------ 字符串的转换----------------");
        // 字符串的转换
        String str14 = "HelloJava";
        // toCharArray() 转化为char型数组
        char[] chars =  str14.toCharArray();
        System.out.println("chars:"+chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }


        //  getBytes()转化为byte数组
        byte[] bytes =   str14.getBytes();
        System.out.println("bytes:"+bytes);
        for (int j = 0; j < bytes.length; j++) {
            System.out.println(bytes[j]);
        }

        System.out.println("------------ 字符串的替换----------------");
        String str15 = "How Do You Do";
        String str16 = str15.replace("o","*");
        System.out.println("替换后的字符串："+str16);


        System.out.println("------------ 字符串的切割----------------");
        String str17 = "aaa,bbb,ccc,ddd";
        String str18 = "AAA.BBB.CCC.DDD";
        String[] strings =  str17.split(",");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        String[] strings1 =  str18.split("\\.");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }
    }
}
