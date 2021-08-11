package exceptiontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("中国");
        list.add("美国");
        list.add("日本");
        list.add("英国");
        try {
            System.out.println(list.get(5));
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("后续代码");  // 会执行
    }
}
