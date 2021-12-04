import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通讯
 * 生成者和消费者，生产者必须要保证消费者能一直消费
 * lock 模式
 */
public class 线程通讯_lock {
    public static void main(String[] args) {
        ChinaBank_lock chinaBank = new ChinaBank_lock();
        chinaBank.setAccountNo("中国银行");
        chinaBank.setMoney(1000); // 初始化银行金额

        // 消费者线程
        new Consume_lock(chinaBank, 900).start();
        // 生产者线程
        new Production_lock(chinaBank, 1000).start();


    }
}

//  银行类
class ChinaBank_lock {
    Lock lk = new ReentrantLock(); // 申请一把锁
    Condition condition = lk.newCondition();
    private String accountNo;// 银行账户
    private int money; // 银行的金额
    private boolean flag = true; // 对账户的标记，有存款标记为true，一开始标记为账户内有钱

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * 银行取钱的方法
     *
     * @param amount 取钱金额
     * @throws InterruptedException 异常
     */
    public void draw(int amount) throws InterruptedException {
        lk.lock();
        try {
            if (flag)/*如果有钱就取*/ {
                if (amount <= money) {
                    System.out.println(getAccountNo() + "取到了：" + amount + "元");
                    money -= amount;
                    System.out.println("取钱后剩余总资产为：" + money + "元");
                    // 取完钱将标记改为false
                    flag = false;

                    condition.signalAll();  // 通知存钱的线程
                    condition.await(); // 无限等待
                } else {
                    System.out.println("余额不足");
                }
            } else /*如果没钱就通知存钱*/ {
                condition.signalAll(); // 通知存钱的线程
            }
        } finally {
            lk.unlock();
        }

    }

    /**
     * 银行存钱的方法
     *
     * @param amount 存入的金额
     */
    public void deposit(int amount) throws InterruptedException {
        lk.lock();
        try {
            if (!flag)/*如果没钱就存入*/ {
                System.out.println(getAccountNo() + "存入了：" + amount + "元");
                money += amount;
                System.out.println("存钱后剩余总资产为：" + getMoney());
                // 存完钱将标记改为true
                flag = true;
                condition.signalAll();  // 通知取钱的线程
                condition.await();// 无限等待
            } else {
                condition.signalAll(); // 通知取钱的线程
            }
        } finally {
            lk.unlock();
        }
    }
}


// 消费者
class Consume_lock extends Thread {
    private ChinaBank_lock chinaBank;
    private int money;

    public Consume_lock(ChinaBank_lock chinaBank, int money) {
        this.chinaBank = chinaBank;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            try {
                chinaBank.draw(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Production_lock extends Thread {
    private ChinaBank_lock chinaBank;
    private int money;

    /**
     * 生产者
     *
     * @param chinaBank 银行类
     * @param money     存入的金额
     */
    public Production_lock(ChinaBank_lock chinaBank, int money) {
        this.chinaBank = chinaBank;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            try {
                chinaBank.deposit(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

