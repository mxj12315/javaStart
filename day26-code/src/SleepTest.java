/**
 * sleep(long millis)，强制让当前线程进入阻塞状态
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        // 子线程
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----" +i );
            }
        });
        t.start();


        // 主线程
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" +i );
            // 当i==30时候让主线程强制休眠
            if (i == 30 ){
                // 让主线程休眠
                Thread.sleep(2);
            }
        }
    }
}
