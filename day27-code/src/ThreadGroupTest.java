/**
 * 线程组ThreadGroup
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        // 创建线程组对象
        ThreadGroup tg = new ThreadGroup("线程组"){/*匿名内部类*/
            // 自定义线程异常
            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println("线程" + t + "出现异常：" + e);
            }
        };
        Thread t = new Thread(tg,()->{
            for (int i = 0; i < 100; i++) {
                if (i == 5){
                    System.out.println(i/0);;
                }
                System.out.println(Thread.currentThread().getName() +"》》》"+ i) ;
            }
        });
        // 启动线程
        t.start();

        System.out.println("当前线程池的线程条数："+tg.activeCount());

    }
}
