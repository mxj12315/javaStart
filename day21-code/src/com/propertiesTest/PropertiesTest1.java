package com.propertiesTest;

import java.util.Properties;

/**
 * properties继承`hashTable` ,它的key和value都是String类型Map
 */
public class PropertiesTest1 {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put("北京","琼");
        p.put("云南","滇");
        p.put("四川","蜀");

        System.out.println(p);
    }
}
