import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 创建线程池
 * 1. ExecutorService代表线程池。ScheduleExecutorService代表有调度功能的线程池
 * 2. Executors：工具类，专门负责创建线程池
 * 将Runable或者Callable接口的实现类提交给线程池
 * 1. pool.submit(Runable runable)
 * 2. pool.submit(Runnable runnable);
 * 关闭线程池
 * 1. pool.shutdown() 等到线程中所有任务完成，关闭线程池
 * 2. pool.shutdownNow() 立即关闭线程池，返回未完成的线程任务（Runable或者Callable接口的实例）
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        // 创建有两条线程的线程池，一次处理两条任务，多出来的任务要排队
        // newFixedThreadPool(int Thread) 创建固定的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        /*
          创建Callable线程对象
         */
        Callable<Integer> callable = () -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "---" + i);
                result = i;
            }
            return result;
        };

        /*
          创建Runnable线程对象
         */
        Runnable runnable = () -> {

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
        };

        // 添加两个任务到线程池
        pool.submit(callable);
        pool.submit(runnable);
        pool.submit(runnable);

        // 任务完成，关闭线程池
        pool.shutdown();
    }
}
