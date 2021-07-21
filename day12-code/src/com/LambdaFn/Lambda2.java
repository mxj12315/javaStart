package com.LambdaFn;

/**
 * 引用实例方法
 */
public class Lambda2 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn1 fn1 = (str,star,end) -> str.substring(star,end);
        String st = fn1.cover("MINXINGJING",1,3);
        System.out.println(st);

        //  进一步简化的Lambda表达式  参数1的类型::某个方法
        Fn1 _fn1 = String::substring;
        System.out.println(_fn1.cover("MINXINGJING",1,3));

    }
}
