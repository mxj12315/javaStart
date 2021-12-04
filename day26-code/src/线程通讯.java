/**
 * 线程通讯
 * 生成者和消费者，生产者必须要保证消费者能一直消费
 * 传统模式
 */
public class 线程通讯 {
    public static void main(String[] args) {
        ChinaBank chinaBank = new ChinaBank();
        chinaBank.setAccountNo("中国银行");
        chinaBank.setMoney(1000); // 初始化银行金额

        // 消费者线程
        new Consume(chinaBank, 900).start();
        // 生产者线程
        new Production(chinaBank, 1000).start();





    }
}

//  银行类
class ChinaBank {
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
     * @param amount 取钱金额
     * @throws InterruptedException 异常
     */
    public synchronized void draw(int amount) throws InterruptedException {
        if (flag)/*如果有钱就取*/ {
            if (amount <= money) {
                System.out.println(getAccountNo() + "取到了：" + amount + "元");
                money -= amount;
                System.out.println("取钱后剩余总资产为：" + money + "元");
                // 取完钱将标记改为false
                flag = false;

                this.notifyAll();  // 通知存钱的线程
                this.wait(); // 无限等待
            } else {
                System.out.println("余额不足");
            }
        } else /*如果没钱就通知存钱*/ {
            this.notifyAll(); // 通知存钱的线程
        }
    }

    /**
     * 银行存钱的方法
     * @param amount 存入的金额
     */
    public synchronized void deposit(int amount) throws InterruptedException {
        if (!flag)/*如果没钱就存入*/ {
            System.out.println(getAccountNo() + "存入了：" + amount + "元");
            money += amount;
            System.out.println("存钱后剩余总资产为：" + getMoney());
            // 存完钱将标记改为true
            flag = true;
            this.notifyAll();  // 通知取钱的线程
            this.wait();// 无限等待
        } else {
            this.notifyAll(); // 通知取钱的线程
        }
    }
}


// 消费者
class Consume extends Thread {
    private ChinaBank chinaBank;
    private int money;

    public Consume(ChinaBank chinaBank, int money) {
        this.chinaBank = chinaBank;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            try {
                chinaBank.draw(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Production extends Thread {
    private ChinaBank chinaBank;
    private int money;

    /**
     * 生产者
     * @param chinaBank 银行类
     * @param money     存入的金额
     */
    public Production(ChinaBank chinaBank, int money) {
        this.chinaBank = chinaBank;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            try {
                chinaBank.deposit(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

