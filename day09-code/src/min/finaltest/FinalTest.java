package min.finaltest;

/**
 * final修饰符
 */
public class FinalTest {

    // final成员变量
    final String name;
    final  int age = 18;
    final boolean sex;

    // 成员变量
    private int score;
    // 类变量
    final  static int number;
    final  static String fastName = "范冰冰";

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    {
        name ="马化腾";
    }

    static {
        number = 125;
        // fastName = "李冰冰";  // 错误不能再赋值
    }

    public FinalTest(){
        sex = true;
    }

    public FinalTest(String li){
        sex =false;
        System.out.println(li);
        System.out.println("类的fastName"+fastName);
    }

    public void  test(){
        // sex = true;  // 不允许在成员方法中给final修饰的成员变量赋值
        final String lastName;
        System.out.println("hello");
    }
}


