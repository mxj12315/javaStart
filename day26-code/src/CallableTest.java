import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable创建多线程
 */
public class CallableTest  {
    public static void main(String[] args) {
        // 第二步  实现Callable实现类的实例
        HelloCallable helloCallable = new HelloCallable();
        // 第三步 将Callable实现类的实例包装成FutureTask
        FutureTask<Integer> futureTask = new FutureTask(helloCallable);
        // 第四步  以FutureTask的实例当做target传入 创建`Thread`实例，主线程代码之前调用start()方法
        new Thread(futureTask).start();


        // 主线程中的代码
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>"+ i);
        }
    }


}

// 第一步 实现Callable接口
class HelloCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception{
        int result = 0;
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>"+ i);
            result = i;
        }

        return result;
    }
}
