package com.LambdaFn;

/**
 * 引用特定对象的实例方法
 */
public class Lambda3 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn2 fn2 = (star,end) -> "MINXINGJING".substring(star,end);
        String st = fn2.convert(1,6);
        System.out.println(st);

        //  进一步简化的Lambda表达式  某个对象::某个方法
        Fn2 _fn2 = "MINXINGJING"::substring;
        System.out.println(_fn2.convert(1,6));

    }
}
