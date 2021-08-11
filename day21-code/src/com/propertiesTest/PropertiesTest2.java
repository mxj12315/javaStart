package com.propertiesTest;

import java.io.*;
import java.util.Properties;

/**
 * properties继承`hashTable` ,它的key和value都是String类型Map
 */
public class PropertiesTest2 {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        File file = new File("E:\\java\\javaStart\\day21-code\\src\\com\\propertiesTest\\b.properties");
        try(
            InputStream inputStream = new FileInputStream(file);
            )
        {
            // 加载文件到Properties中
            p.load(inputStream);
            System.out.println(p);  // {"重庆"="渝", "广西"="桂" }
            // 设置属性
            p.setProperty("江苏","苏");
            System.out.println(p);
            // 获取属性
            String sh = p.getProperty("\u91cd\u5e86");
            System.out.println(sh);
            String gx = p.getProperty("广西");
            System.out.println(gx);

        }



    }
}
