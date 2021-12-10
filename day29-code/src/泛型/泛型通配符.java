package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符<?>   程序无法知道？处所代表的类型是什么，不能添加元素，只能取出，并且取出的元素当做Object处理
 */
public class 泛型通配符 {
    //    public static void foreach(List<Object> list) 错误的
    //    public static void foreach(List list) 不推荐的，会导致泛型信息丢失
    public static void foreach(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            // 下面代码异常
            // list.add("java");
            System.out.println(list.get(i));
        }

    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        foreach(numberList);

        System.out.println("--------------");
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.2);
        doubleList.add(3.2);
        doubleList.add(6.3);
        foreach(doubleList);

    }
}
