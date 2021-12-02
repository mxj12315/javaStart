/**
 * 第二种创建多线程的方法Runnable
 */
public class RunnableTest {
    public static void main(String[] args) {
        // 第二步 创建`Runnable`子类的实例
        HelloRunnable target = new HelloRunnable();
        // 第三步 以`Runnable`实现类为实例为`target`，创建`Thread`实例，主线程代码**之前**调用`start()`方法
        new Thread(target).start();

        // 主线程中的代码
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }
    }
}

// 第一步 实现Runnable接口
class HelloRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }
    }
}