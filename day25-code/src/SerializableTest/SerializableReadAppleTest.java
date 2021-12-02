package SerializableTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java反序列化
 */
public class SerializableReadAppleTest {
    public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {

        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Apple.txt"));

        ) {
            Apple apple = (Apple) ois.readObject();
            System.out.println(apple.color);
            System.out.println(apple.weight);
            System.out.println(apple.varieties);  // 该属性被transient修饰，无法被序列化
            System.out.println("------------");
            Apple apple2 = (Apple) ois.readObject();
            System.out.println(apple.color);
            System.out.println(apple.weight);
            System.out.println(apple.varieties);

        }
    }
}
