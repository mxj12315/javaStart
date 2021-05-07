package min.jiekou1;

public interface Jk {
    // 系统会默认添加上普public static final
    int AGE = 18;

    // 抽象方法，系统会默认添加上普public abstract
    void test();

    // 类方法 前面默认添加public

    static void test(String name){
        System.out.println(name);
    }
    // 实例方法，需要在前面添加default

    default void run(){
        System.out.println("这是接口中的实例方法");
    }

    // java8之后可以有main方法
    public static void main(String[] args) {
        System.out.println("接口中的main方法");
        // 接口调用类变量
    }
}
