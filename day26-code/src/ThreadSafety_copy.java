/**
 * 线程安全,修改之后
 * synchronized(共享资源/竞争资源){
 * 线程执行代码
 * }
 */
public class ThreadSafety_copy {
    public static void main(String[] args) throws InterruptedException {
        Bank_copy bank = new Bank_copy();
        bank.setAccountNo("中国bank");
        bank.setMoney(1000);
        System.out.println("取款之前总资产为：" + bank.getMoney());
        // A取钱
        new DrawMoney_copy(bank, 1000).start();
        new DrawMoney_copy(bank, 1000).start();
    }
}


//  银行类
class Bank_copy {
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
}


// 取钱类
class DrawMoney_copy extends Thread {
    private  Bank_copy bank;
    private int amount;// 取钱的金额

    public DrawMoney_copy(Bank_copy bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    /**
     * 取钱的方法
     */
    @Override
    public void run() {
        // 同步代码块
        synchronized (bank) {
            if (amount <= bank.getMoney()) {
                System.out.println(bank.getAccountNo() + "取到了：" + amount + "元");
                bank.setMoney(bank.getMoney() - amount);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("剩余总资产为：" + bank.getMoney());
            } else {
                System.out.println("余额不足");
            }
        }
    }
}