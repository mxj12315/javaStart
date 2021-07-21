package com.person;

/**
 * Person测试类
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = Person.MEN;
        p1.info();
        String desc1 = p1.getDesc();
        System.out.println(desc1);

        Person p2 = Person.WOMEN;
        p2.info();
        String desc2 = p2.getDesc();
        while (true){
            System.out.println(desc2);

        }

    }
}
