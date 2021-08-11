package exceptiontest;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义异常对象
 */
public class ExceptionTest3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();

        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("后续代码");  // 会执行
    }
}
