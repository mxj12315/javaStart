package 使用注解添加点击事件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ListenerInstallerProcessTools {
    public static void process(Object object) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = object.getClass();  // 获取实例对应的类
        Field[] fields = clazz.getDeclaredFields(); // 获取该类的所有字段，包括private，protect
        for (Field f : fields) { // 遍历所有的字段
            f.setAccessible(true); // 设置信息可到达的

            Object o = f.get(object);   // 通过实例获取值
            // 如果类型是f 的 值 是AbstractButton
            if (o instanceof AbstractButton) {
                // 获取字段上的注解
                ListenerInstaller annotation = f.getAnnotation(ListenerInstaller.class);
                if (annotation != null) {
                    Class<?> listener = annotation.listener();// 获取注解的listener属性
                    String msg = annotation.msg();// 获取注解的msg属性

                    ActionListener myActionListener = (ActionListener) listener.getConstructor(String.class)/*获取类*/.newInstance(msg);/*创建实例*/
                    AbstractButton button = (AbstractButton) o; // 将o转换为button
                    button.addActionListener(myActionListener); // 为按钮添加事件

                }
            }


        }
    }
}
