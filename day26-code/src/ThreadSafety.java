/**
 * 线程安全,修改之前
 */
public class ThreadSafety {
    public static int money = 1000; // 总资产

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        bank.setAccountNo("中国bank");
        bank.setMoney(1000);
        System.out.println("取款之前总资产为：" + bank.getMoney());
        // A取钱
        new DrawMoney(bank,1000).start();
        new DrawMoney(bank,1000).start();
    }
}


//  银行类
class Bank  {
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
class  DrawMoney extends Thread{
    private Bank bank;
    private int amount;// 取钱的金额

    public DrawMoney(){}
    public DrawMoney(Bank bank,int amount){
        this.bank = bank;
        this.amount = amount;
    }

    /**
     * 取钱的方法
     */
    @Override
    public void run(){
        if (amount <= bank.getMoney()){
            System.out.println(bank.getAccountNo() + "取到了：" + amount +"元");
            bank.setMoney(bank.getMoney() - amount);
            System.out.println("剩余总资产为：" + bank.getMoney());
        }else {
            System.out.println("余额不足");
        }
    }

}