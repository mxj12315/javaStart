package 注解测试;

import java.lang.reflect.Method;

/**
 * 测试@test注解的类
 */
public class AnnotationTestTools {
    public static void main(String[] args) {
        AnnotationTestTools.process(MethodTest.class);
    }

    public static void process(Class<?> clazz) {
        // 用于统计失败和成功的数量
        int passed = 0;
        int failed = 0;
        try {
            Method[] methods = clazz.getMethods();// 获取指定类的所有方法
            // 通过获取类的构造器创建实例
            Object instance = clazz.getConstructor().newInstance();
            for (Method m : methods) {   // 遍历所有的方法
                // 使用实例调用方法
                System.out.println("方法名：" +m.getName());
                // 判断方法是否有指定的注解
                if (m.isAnnotationPresent/*是否存在注解*/(Test.class)) {
                    try {
                        m.invoke(instance);//invoke 援引
                        passed++;// 执行成功自加
                    } catch (Exception e) {
                        failed++;
                    }
                }
            }
            System.out.printf("总的方法有%s个，总额执行了%s个方法，执行成功%s个方法，执行失败%s个方法", methods.length, passed + failed, passed, failed);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
