package com;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * java国际化
 */
public class InterNational {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println(defaultLocale);
        // 加载国际化资源文件
        ResourceBundle r = ResourceBundle.getBundle("msg",defaultLocale);
        String _msg1 = r.getString("message");
        String _mgs2 =  MessageFormat.format(r.getString("date"),new Object[] {"马云",new Date()});
        System.out.println(_msg1);
        System.out.println(_mgs2);
    }
}
