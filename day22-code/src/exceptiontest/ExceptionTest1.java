package exceptiontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest1 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            File file = new File("a.txt");  // checked异常，受检异常，
            inputStream = new FileInputStream(file);
        } catch (Exception ex) {
            ex.printStackTrace();
//            ex= null;

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        System.out.println("后续代码");  // 不会执行
    }
}
