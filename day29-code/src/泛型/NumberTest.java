package 泛型;

/**
 * 泛型类的继承
 *
 */
public class NumberTest<T,E> extends Apple1<String,Integer> {

}
/**
 * 泛型类
 */
class Apple1<T, E> {
    private T color;
    private E weight;
    public Apple1() {

    }

    public Apple1(T color, E weight) {
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

