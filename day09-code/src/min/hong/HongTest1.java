package min.hong;

public class HongTest1 {
    public static void main(String[] args) {
        // 以下代码 0个变量，1个对象
        final String str1 = "wo";
        final String str2 = str1 + "ai";
        final String str3 = str2 + "zhong";
        System.out.println(str3);
        // 完全等同于System.out.println("woaizhong");
    }
}
