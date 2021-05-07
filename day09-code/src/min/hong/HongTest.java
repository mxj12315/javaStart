package min.hong;

public class HongTest {
    public static void main(String[] args) {
        final int a = 12;
        System.out.println(a);

        // 上面的代码等同于，final修饰的变量在编译时会被替换
        System.out.println(12);

        // 不使用final修饰

        String str1 = "min";
        String str2 = "xingjing";
        String str3 = str1 + str2 ;
        String str4 = "min" + "xingjing";
        System.out.println(str3 == str4);  //false

        // 不使用final修饰
        final String _str1 = "min";
        final String _str2 = "xingjing";
        String _str3 = _str1 + _str2 ;  // final修饰的变量给定初始值编译时会被宏替换，等同于 String _str4 = "min" + "xingjing";
        String _str4 = "min" + "xingjing";
        System.out.println(_str3 == _str4);  //true

    }
}
