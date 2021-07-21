package com.neiBuLei3;

public class Go {
    public static void main(String[] args) {
        // 1、使用抽象类创建创建匿名内部类
        // 向上转型
        Animal animal =new Animal("小狗") {
            // 匿名内部类的类体
            @Override
            public void run() {
                System.out.println("动物都能跑");
            }

            @Override
            public void eat() {
                System.out.println("动物都会吃东西");
            }

            @Override
            public void jump() {
                super.jump();
                System.out.println("跳的很高");
            }

            // 自定义的方法
            public void test(){
                System.out.println("匿名内部类的自定义test方法");
            }
        };

        animal.run();
        animal.eat();
        animal.jump();
        // 无法调用自定义的匿名内部类的方法
        // 编译期间类型是Animal类型，没有test方法；
        // 无法强制转换类型，因为内有类名，无法写 （类型）animal
        // animal.test();

        // 2、使用接口类创建创建匿名内部类
        // 向上转型
        Plant plant =new Plant() {
            @Override
            public void color() {
                System.out.println("颜色是绿色的");
            }

            @Override
            public double height() {
                return 0;
            }
        };

        plant.color();
        System.out.println(plant.height());;

    }
}
