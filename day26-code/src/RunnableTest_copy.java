/**
 * 第二种创建多线程的方法Runnable
 */
public class RunnableTest_copy {
    public static void main(String[] args) {
        // 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + ">>>" + i);
                }
            }
        }).start();

        // lambda表达式
        new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + ">>>" + i);
            }

        }).start();

        // 主线程中的代码
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }
    }
}

