/**
 * 第一种多线程 继承Thread
 */
public class ThreadTest {
    public static void main(String[] args) {
        Hello hello = new Hello();
        // hello.run(); // 不是多线程
        hello.start();
        for (int i = 0; i < 10000; i++) {
            // 获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }


        // 使用匿名内部类创建
        new Thread(){
            // 匿名内部类的类体
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // 获取当前线程的名字
                    System.out.println(Thread.currentThread().getName() + ">>>" + i);
                }
            }
        }.start();

        // 使用lambda表达式创建
        // 匿名内部类的类体
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // 获取当前线程的名字
                System.out.println(Thread.currentThread().getName() + ">>>" + i);
            }
        }).start();
    }
}


class Hello extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }
    }
}