package hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 不同方式创建的字符串变量能否加入hashSet集合
 */
public class HashSetTest1 {
    public static void main(String[] args) {
        Set<String> set =new HashSet<>();
        String str = "java";
        String str1 =new String("java");
        set.add(str);
        set.add(str1); // 加不进去
        System.out.println(set);
    }

}
