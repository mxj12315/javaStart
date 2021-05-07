import java.lang.reflect.Array;

/**
 * 数组：类型统一 ，长度不可改变
 */
public class Array01 {
    public static void main(String[] args) {
        // 1 数组静态初始化
        // 1.1 一般格式 数据类型[] 变量名 = new 数据类型[]{元素1，元素2}
        int[] arr0 = new int[]{1, 2, 3, 5};
        System.out.println(arr0.length);  //4
        String[] arr1 = new String[]{"你好", "hello", "java"};
        System.out.println(arr1.length); //3
        // 1.2 简写格式 数据类型[] 变量名 = {元素1，元素2}
        int[] arr2 = {11, 12, 36, 69};
        System.out.println(arr2.length); // 4

        // 2 动态初始化
        // 2.1 一般格式 数据类型[] 变量名 = new 数据类型[数组长度]
        int[] arr3 = new int[8];
        System.out.println(arr3.length); // 8
    }
}