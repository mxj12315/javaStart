package hashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * hashSet集合
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 一般类型申明为接口，适用性强，可以转型其他子类
        // 创建Integer对象
        Collection<Integer> collection = new HashSet<>();
        // 自动装箱
        collection.add(123);
        collection.add(999);
        collection.add(45);
        collection.add(45); // 加不进去
        System.out.println(collection);

        // 创建Dog对象
        Collection<Dog> collection1 = new HashSet<>();
        collection1.add(new Dog("黑色", 12.1));
        collection1.add(new Dog("黑色", 11.1));
        collection1.add(new Dog("白色", 12.1));
        collection1.add(new Dog("黑色", 12.1));// 加不进去
        collection1.add(new Dog("白色", 12.1));// 加不进去


        System.out.println(collection1);
        System.out.println(collection1.size());

    }
}


class Dog{
    String color;
    double weight;

    public Dog(){};

    public Dog(String color, double weight){
        this.color = color;
        this.weight = weight;
    };

    @Override
    public int hashCode() {
        // 为了避免偶然相等乘上一个质数
        int prime = 31 ;
        // color是字符串使用hashCode方法， weight是double使用强制类型转换为int
        return this.color.hashCode()  * prime+ (int)this.weight ;
    }

    /**
     * 重写equals
     * @param obj 要比较的对象
     * @return 比较结果
     */
    @Override
    public boolean equals(Object obj){
        // 如果地址值相同证明是同一个对象
        if (this==obj) return true;
        // 如果obj不为空且obj类型和Dog的类型相同证明是同一个对象
        if (obj!=null  && obj.getClass()==Dog.class){
            return this.color.equals(((Dog) obj).color)  && this.weight - ((Dog) obj).weight < 1e-2/*两个浮点数差小于10的-2次方*/;
        }
        return false;
    };


    @Override
    public String toString() {
        return "Dog = [color = " + color + ",weight = " + weight + "]";
    }
}