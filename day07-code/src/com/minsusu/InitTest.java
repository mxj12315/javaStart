package com.minsusu;


/**
 * 初始化块
 *  实例初始化代码块
 */
public class InitTest {
    // 定义实例变量,编译时会还原到构造器中的一条赋值语句
    int age1 = 30;

    // 实力初始化代码块，编译时会被还原到每一个构造器中
    {
        System.out.println("实例初始化块");
        age = 5 ;
        age1 = 10 ;
    }

    // 定义实例变量,编译时会还原到构造器中的一条赋值语句
    int age = 20;

    public InitTest(){
        System.out.println("无参数构造器");
    }


    public InitTest(String name){
        System.out.println("有参数构造器："+name);
    }


    public static void main(String[] args) {
        InitTest initTest =new InitTest();
        InitTest initTest1 =new InitTest("min");
        System.out.println(initTest.age);   // 20
        System.out.println(initTest1.age1);  // 10
    }
}
