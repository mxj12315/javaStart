/**
 * 数组遍历
 */
public class Array02 {
    public static void main(String[] args) {
        // 1 数组遍历for
        int[] arr = new int[]{10,12,50,99,100,54};
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

            System.out.println("------------------------");
            // forEach增强循环
            for (int j:arr) {
                System.out.println(j);
        }
    }
}
