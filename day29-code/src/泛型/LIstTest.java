package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * A是B的子类，A[]是B[]的子类，但类<A>不是类<B>的子类
 * Integer是Number的子类，但是List<Integer>不是List<Number>的子类
 */
public class LIstTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        // 下面代码是错误的
        //  List<Number> numberList = integerList;

    }
}
