/**
 * 多参数String[]
 */
public class Multiparameter2 {
    public static void main(String[] args) {

        multiparameter(2,new String[]{"张三","李四","王五"});
    }


    public static void multiparameter(int a,String[] names){
        System.out.println("参数a:"+ a);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
