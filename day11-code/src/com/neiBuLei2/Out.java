package com.neiBuLei2;

import org.jetbrains.annotations.Contract;

public class Out {
    // 成员变量
    int age = 18;
    String firstName ="张三";
    //  类变量
    static boolean isFlag =true;
    static long money =100L;
    // 非静态内部类
    class In1{
        // 非静态内部类的成员变量
        String In1FistName = "非静态内部类";
        double price = 23.6;

        // 非静态内部类的类变量,需要使用final修饰
        static final char hz = '中';


        // 非静态内部类的成员方法
        public  int sum(int a, int b){
            return a + b ;
        }

        /**
         * 重写toString
         * @return
         */
        @Override
        public String toString() {
            return "In1{" +
                    "In1FistName='" + In1FistName + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    // 静态内部类
    static class In2 {
        // 静态内部类的类变量
        static int number = 12;
        // 静态内部类成员变量
        int[] arr = new int[]{1,2,3};


        // 静态内部类的类方法
        public  static String name(String firstName, String lastName){
            return firstName + lastName;
        }

        // 静态内部类的成员方法
        public int array(int[] arr){
            return arr[0];
        }

        /**
         * 重写toString
         * @return
         */
        @Override
        public String toString(){
            return "In2[number="+number+"]";
        }

    }

    public void desc(){
        // 在外部类的内部使用非静态内部类，与普通类相同
        In1 in1 = new In1();
        // 在外部类的内部使用静态内部类，与普通类相同
        In2 in2 = new In2();
    }
}
