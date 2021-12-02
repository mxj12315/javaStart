/**
 * 线程优先级priority
 * 1. MIN_PRIORITY:1
 * 2. NORM_PRIORITY:5
 * 3. MAX_PRIORITY:10
 */
public class PriorityTest {
    public static void main(String[] args) {
        // 子线程1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----" +i );
            }
        });
        t1.setPriority(Thread.MIN_PRIORITY/*优先级1*/);  //设置优先级
        t1.start();

        // 子线程2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----" +i );
            }
        });
        t2.setPriority(Thread.NORM_PRIORITY/*优先级5*/);  //设置优先级
        t2.start();

        // 子线程3
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----" +i );
            }
        });
        t3.setPriority(Thread.MAX_PRIORITY/*优先级10*/);  //设置优先级
        t3.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "----" +i );
        }


    }

}
