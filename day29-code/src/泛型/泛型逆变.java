package 泛型;

import java.util.ArrayList;
import java.util.List;

public class 泛型逆变 {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(8);
        numbers.add(56);
        numbers.add(2.6);

        List<? super Integer>  intList= numbers;

        // 添加元素
        intList.add(6);
        intList.add(9);
        intList.add(61);
        System.out.println(intList); //  [2, 8, 56, 6, 9, 61]

        // 取出元素  只知道是Integer的父类，不能确定是哪一个父类
        Object object = intList.get(3); // 只能是Object
        // Integer integer = (Integer) object;  // 不可以转换
        System.out.println(object);


    }

}
