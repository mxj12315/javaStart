/**
 * join等待线程
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        // 子线程 B在刷锅
        Thread t = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ">>>>>" + i);
                }
            }
        };
        t.start();


        // 主线程   A洗菜
        for (int i = 0; i < 100; i++) {
           // A洗菜主线程
            System.out.println(Thread.currentThread().getName() + ">>>>>" + i);

            if (i==20){
                //  等待B洗锅完成,A主线程才能运行
                t.join();
            }
        }
    }
}



