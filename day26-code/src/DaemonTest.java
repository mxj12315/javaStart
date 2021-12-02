/**
 * daemon守护线程
 */
public class DaemonTest {
    public static void main(String[] args) throws IllegalThreadStateException{
        // 子线程
        Thread t = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----" +i );
            }
        });

        // 将T线程设置为后台线程
        // 必须先设置，在启动
        t.setDaemon(true);  // 当所有的前台线程死亡，那么后台线程自动死亡
        t.start();

        // 错误的
        // t.start();
        // t.setDaemon(true);


        //  主线程没有什么代码
        // 改代码主线程很快执行完成，导致后台线程直接死亡


    }
}
