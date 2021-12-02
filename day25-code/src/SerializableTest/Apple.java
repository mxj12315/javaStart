package SerializableTest;

import java.io.Serializable;

public class Apple implements Serializable {
    String color;
    double weight;
    /* transient 瞬时的   将修饰的对象排除到序列化之外  一般用于关键数据泄露*/
    transient String  varieties; // 品种

    public Apple() {
    }

    public Apple(String color, double weight, String varieties) {
        this.color = color;
        this.weight = weight;
        this.varieties = varieties;
    }


}
