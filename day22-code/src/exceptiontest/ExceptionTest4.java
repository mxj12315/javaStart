package exceptiontest;


public class ExceptionTest4 {
    private int age;

    public ExceptionTest4(){}

    // 方法签名上抛出异常对象
    public ExceptionTest4(int age) throws ET{
        if (age>100){
            throw new ET("非法年龄大于100");
        }
        this.age =age;
    }

    public static void main(String[] args) {
        try {
            ExceptionTest4 except = new ExceptionTest4(120);
            System.out.println(except.age);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

/**
 * 自定义异常类
 */
class ET  extends Exception {
    public ET(){
        // 默认调用父类的无参构造器
    }

    public ET(String message){
        super(message);
    }
}



