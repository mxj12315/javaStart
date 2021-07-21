package linkhashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkHashSetTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("b");
        set.add("a");
        set.add("c");
        System.out.println(set);  //[b, a, c]

    }
}
