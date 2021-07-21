package com.neiBuLei4;

/**
 * 使用函数式接口创建匿名内部类、lambda表达式
 */
public class Go {
    public static void main(String[] args) {

        // 1 普通写法
        Plant p = new Plant() {
            @Override
            public void color() {
                System.out.println("函数式接口");
            }
        };
        p.color();


        // 2 lambda简化写法
        Plant p1 = () ->{
            System.out.println("使用了Lambda表达式");
        };
        p1.color();

        /*
        // 2.1 lambda简化写法1
        Plant p2 = () -> System.out.println("使用了Lambda表达式");
        p2.color();

        // 2.2 lambda简化写法1
        Plant p3 = res -> res*res;
        p3.color();

         */
    }
}
