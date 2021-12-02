import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable创建多线程,lambda表达式
 */
public class CallableTest_copy  {
    public static void main(String[] args) {

        new Thread(new FutureTask<>(() -> 123)).start();


        // 主线程中的代码
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>"+ i);
        }
    }


}


