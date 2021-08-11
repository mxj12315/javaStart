package exceptiontest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * catch和throw一起使用
 */
public class ExceptionTest5 {
    public static void main(String[] args) {
        // 这种写法必须要处理checked异常
        // FileInputStream fls = new FileInputStream("fileName");

        // 这种将checked异常转为Runtime异常，不需要处理
        new ExceptionTest5().test("a.txt");
    }

    // catch和throw一起使用 抛出自定义异常对象
    public void test(String fileName) throws IllegalArgumentException {
        try {
            // 会抛出FileNotFound的checked异常
            new FileInputStream("fileName");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println(fileName + "文件不存在");
            // 将checked异常转为Runtime异常
            throw new IllegalArgumentException("没找到");
        }
    }
}
