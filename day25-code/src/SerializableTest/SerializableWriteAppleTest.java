package SerializableTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * java序列化
 */
public class SerializableWriteAppleTest {
    public static void main(String[] args) {
        Apple apple =new Apple("红色",10.3,"红富士");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Apple.txt"));
            oos.writeObject(apple);
            // 修改后再次序列化
            apple.color ="绿色";
            oos.writeObject(apple); // 不会改变 ，输出仍然是 color = 红色 只是输出对象的序列化版本号

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
