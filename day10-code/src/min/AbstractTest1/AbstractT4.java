package min.AbstractTest1;

public class AbstractT4 {
    public static void main(String[] args) {
       // 使用父类型接收子类的引用,向上转型
        AbstractAnimal animal1 = new AbstractBird();
        AbstractAnimal animal2 = new AbstractDog();
        // 多态
        animal1.movie();
        animal2.movie();
    }
}
