package com.LambdaFn;

import java.util.Date;

/**
 * 构造器引用
 */
public class Lambda4 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn3 fn3 = (year, month, day) -> new Date(year, month, day);
        Date date = fn3.getTime(116, 7, 1);
        System.out.println(date);  // Mon Aug 01 00:00:00 CST 2016

        //  进一步简化的Lambda表达式  类名::new
        Fn3 _fn3 = Date::new;
        System.out.println(_fn3.getTime(116, 7, 1));  // Mon Aug 01 00:00:00 CST 2016

    }
}
