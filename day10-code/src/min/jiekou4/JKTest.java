package min.jiekou4;

public interface JKTest {
    /* 改造前
    default void run(){
        int a = 10;

        // 重复的代码
        System.out.println(123);
    }


    default void eat(){
        String name = "马化腾";

        // 重复代码
        System.out.println(123);
    }
    */

    // 改造后
    default void run() {
        int a = 10;
        System.out.println(a);
        go();
    }


    default void eat() {
        String name = "马化腾";
        System.out.println(name);
        go();
    }

    private void go(){
        // 公共代码
        System.out.println("我是private修饰的公共代码");
    }

     static void main(String[] args) {

    }

}
