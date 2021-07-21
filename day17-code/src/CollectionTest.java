import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        // 菱形语法
        Collection<String> c = new HashSet<>();
        // 添加
        c.add("中国");
        c.add("美国");
        c.add("日本");
        System.out.println(c);  //[美国, 中国, 日本]
        // 删除
        c.remove("日本");
        System.out.println(c);  //[美国, 中国]
        // 集合大小
        int size = c.size();
        System.out.println(size); //2

        // 判断是否为空
        boolean isEmpty = c.isEmpty();
        System.out.println(isEmpty);// false
        // 判断是否为空
        System.out.println(c.contains("中国"));  // true
        System.out.println(c.contains("日本"));  // false

        // 遍历
        // 遍历foreach
        for (String s : c) {
            System.out.println(s);
        }

        // 遍历:Iterator遍历器使用while
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()){
            String str =  iterator.next();
            System.out.println(str);
        }
        System.out.println("--------------------");
        // 遍历:Iterator遍历器使用for
        for ( Iterator<String> i = c.iterator();i.hasNext(); ){
            String str =  i.next();
            System.out.println(str);
        }
        // 遍历：使用lambda表达式，函数式接口1
        c.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 遍历：使用lambda表达式，函数式接口2
        System.out.println("--------------------");
        c.forEach(s -> System.out.println(s));
        // 遍历：使用lambda表达式，函数式接口3
        System.out.println("--------------------");
        c.forEach( System.out::println);
    }
}
