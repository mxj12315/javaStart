package 注解;


@First
public class Par {
    @First
    public static void main(String[] args) {

    }
    @Fourths({@Fourth(name="李"),@Fourth(name="王")})  // java8以前重复注解
    @Second(age=12,flag = true,name = "java",value = 46)
    public static void test(){

    }
    @Fourth(name = "张三")
    @Fourth(name = "李四")
    @Third(26)  // 注解只有一个value可以省略value
    public void third(){

    }
}
