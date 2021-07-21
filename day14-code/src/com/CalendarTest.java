package com;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("今年的第几天："+calendar.get(Calendar.DAY_OF_YEAR) );
        System.out.println("今年是哪一年："+calendar.get(Calendar.YEAR)+"年" );
        System.out.println("本月是哪一个月："+(calendar.get(Calendar.MONTH)+1)+"月");
        System.out.println("今天是几号："+calendar.get(Calendar.DATE)+"号");
    }
}
