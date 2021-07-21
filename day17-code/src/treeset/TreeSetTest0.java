package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet添加一般元素
 */
public class TreeSetTest0 {
    public static void main(String[] args) {
        Set<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(2);
        ts.add(5);
        ts.add(8);
        ts.add(0);
        ts.add(-1);
        System.out.println(ts);  //[-1, 0, 1, 2, 5, 8]


        // 以Unicode编码排序
        Set<String> ts1 = new TreeSet<>();
        ts1.add("JAVA");
        ts1.add("A");
        ts1.add("SS");
        ts1.add("FFF");
        ts1.add("B");
        ts1.add("GG");
        System.out.println(ts1);  // [A, B, FFF, GG, JAVA, SS]
    }
}
