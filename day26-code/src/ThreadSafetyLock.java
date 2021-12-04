import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全,修改之后
 * synchronized 修饰方法
 * }
 */
public class ThreadSafetyLock {
    public static void main(String[] args) throws InterruptedException {
        BankLock bank = new BankLock();
        bank.setAccountNo("中国bank");
        bank.setMoney(1000);
        System.out.println("取款之前总资产为：" + bank.getMoney());
        // A取钱
        new DrawMoneyLock(bank, 1000).start();
        new DrawMoneyLock(bank, 1000).start();
    }
}


//  银行类
class BankLock {
    // 买一把锁
    Lock lk = new ReentrantLock();
    private String accountNo;// 银行账户
    private int money; // 银行的金额

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

    // 银行取钱的方法
    public void draw(int amount) {
        lk.lock(); // 上锁
        try {
            // 修改共享资源的代码
            if (amount <= getMoney()) {
                System.out.println(getAccountNo() + "取到了：" + amount + "元");
                setMoney(getMoney() - amount);
                System.out.println("剩余总资产为：" + getMoney());
            } else {
                System.out.println("余额不足");
            }
        } finally {
            lk.unlock();// 开锁
        }

    }
}


// 取钱类
class DrawMoneyLock extends Thread {
    private BankLock bank;
    private int amount;// 取钱的金额

    public DrawMoneyLock(BankLock bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {        // 同步方法
        bank.draw(amount);
    }

}