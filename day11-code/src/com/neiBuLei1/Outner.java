package com.neiBuLei1;

public class Outner {
    private double price  = 10.0;
    // 非静态内部类
    class Inner{
        private double price = 20.0;
        // 可以访问外部类的私有成员
        public  void t() {
            // 局部变量
            double price = 30.0;
            System.out.println("局部变量的price："+price);
            System.out.println("当前类的price："+this.price);
            System.out.println("外部类的price："+ Outner.this.price);
        }

        /* 非静态内部类中不能有静态成员，除非声明为常量
        public static int a = 10;
        static {
            String name = "张学友";
        }

        public static void test(){}
        */

        // 合法的声明
        public static final int age = 18;

    }

    // 静态内部类
    static class Inner1{
        private int num;
        public static  void test(){}
    }

    public static void main(String[] args) {
        // 错误，Inner类属于非静态，static方法中无法访问非静态成员
        //Outner outner = new Inner();
        Outner outner =new Outner();
        outner.go();

        // 正确，静态方法可以直接访问静态成员
        Inner1 inner1 = new Inner1();

    }


    public void go(){
        // 合法的，非静态方法访问非静态成员
        Inner inner =new Inner();
        inner.t();
    }
}
