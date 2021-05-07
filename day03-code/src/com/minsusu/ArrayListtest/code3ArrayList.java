package com.minsusu.ArrayListtest;

import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList集合
 * 存储自定义对象
 */
public class code3ArrayList {
    public static void  main(String[] args){
        ArrayList<Person> list1 = new ArrayList<>();
        Person p1 = new Person("张三",28);
        Person p2 = new Person("李四",16);
        Person p3 = new Person("王五",30);
        Person p4 = new Person("吴六",45);
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list1.add(p4);
        System.out.println(list1);

    }
}


class Person {
    public String name;
    public int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name:" + name +
                ", age:" + age +
                '}';
    }
}