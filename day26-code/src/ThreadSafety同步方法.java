/**
 * 线程安全,修改之后
 * synchronized 修饰方法
 * }
 */
public class ThreadSafety同步方法 {
    public static void main(String[] args) throws InterruptedException {
        Bank同步方法 bank = new Bank同步方法();
        bank.setAccountNo("中国bank");
        bank.setMoney(1000);
        System.out.println("取款之前总资产为：" + bank.getMoney());
        // A取钱
        new DrawMoney同步方法(bank, 1000).start();
        new DrawMoney同步方法(bank, 1000).start();
    }
}


//  银行类
class Bank同步方法 {
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
    public synchronized void draw(int amount) {
        if (amount <= getMoney()) {
            System.out.println(getAccountNo() + "取到了：" + amount + "元");
            setMoney(getMoney() - amount);
            System.out.println("剩余总资产为：" + getMoney());
        } else {
            System.out.println("余额不足");
        }
    }
}


// 取钱类
class DrawMoney同步方法 extends Thread {
    private Bank同步方法 bank;
    private int amount;// 取钱的金额

    public DrawMoney同步方法(Bank同步方法 bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {        // 同步方法
        bank.draw(amount);
    }

}