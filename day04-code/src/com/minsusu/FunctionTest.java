package com.minsusu;


/**
 * 函数的参数
 *  1、基本类型
 *  2、引用类型
 */
public class FunctionTest {
    public static void main(String[] args){
        // 传递参数是基本数据类型，原始的数据不会改变
        int a = 3;
        int b = 4;
        exchange(a,b);
        System.out.println("a的值:"+a);  // a的值:3
        System.out.println("b的值:"+b);  // b的值:4

        // 传递参数是引用类型，原始的值不会改变，但是内存地址对应的内容会发生改变
        Person person =new Person();
        person.name = "马云";
        exchange(person);
        System.out.println(person.name);  //内容发生改变=>王健林
        System.out.println(person);  //  地址值不会改变Person@1b6d3586
    }

    /**
     * 交换两个数字的位置
     * @param a  第一个数字
     * @param b  第二个数字
     */
    public static void exchange(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;

    }


    public static void exchange(Person person){
        person.name = "王健林";
        person = null;
    }
}


class Person {
    String name;
}