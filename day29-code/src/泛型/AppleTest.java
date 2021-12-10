package 泛型;

public class AppleTest {
    public static void main(String[] args) {
        Apple<String,Double> apple = new Apple<>("红色",3.4);
        apple.setColor("绿色");
        apple.setWeight(2.6);
        System.out.println(apple.getColor());
        System.out.println(apple.getWeight());

        System.out.println("-----------------");
        Apple<Character,Float> apple2 = new Apple<>('J',3.4f);
        apple2.setColor('K');
        apple2.setWeight(2.0F);
        System.out.println(apple2.getColor());
        System.out.println(apple2.getWeight());

        System.out.println("-----------------");
        // 如果不传入类型，那么编译器将把他们当成Object使用
        Apple apple3 = new Apple<>("红色",3.4);
        Object ocolor = apple3.getColor();
        String scolor = (String) ocolor; // 需要强制转换类型
        System.out.println(scolor);

        System.out.println("-----------------");
        // 并不存在的泛型类,Apple<String,Integer>和Apple<String,Double>都是同一个类
        Apple<String,Integer> apple4 = new Apple<>("黄色",2);
        Apple<String,Double> apple5 = new Apple<>("白色",2.3);
        System.out.println( apple4.getClass());
        System.out.println( apple4.getClass() == apple5.getClass()); // true



    }
}

/**
 * 泛型类
 */
class Apple<T, E> {
    private T color;
    private E weight;

    public Apple(T color, E weight) {
        this.color = color;
        this.weight = weight;
    }

    public T getColor() {
        return this.color;
    }

    public void setColor(T color) {
        this.color = color;
    }

    public E getWeight() {
        return this.weight;
    }

    public void setWeight(E weight) {
        this.weight = weight;
    }
}
