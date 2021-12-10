package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * < ？ extends A > 传入的类型必须是A的子类或A
 * 只能取出元素
 */
public class 泛型协变 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(12);
        integerList.add(15);
        integerList.add(92);
        List<? extends Number> numbers = integerList;
        Number number = numbers.get(0);
        Number number1 = numbers.get(1);
        System.out.println(number);
        System.out.println(number1);

        泛型协变.sum(numbers);


        List<Double> doubleList = new ArrayList<>();
        doubleList.add(12.2);
        doubleList.add(15.6);
        doubleList.add(92.6);
        泛型协变.sum(doubleList);
    }

    // 上限通配符取出元素
    public static void sum(List<? extends Number> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
           sum += list.get(i).intValue();
        }
        System.out.println(sum);
    }

    // 上限通配符添加元素
    public static void add(List<? extends Number> list){
        // 错误的
        // list.add(2);
    }
}
