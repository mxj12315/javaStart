package min.singleinstance;

public class InstanceMain {
    public static void main(String[] args) {
        InstanceTest i1 = InstanceTest.instance();
        InstanceTest i2 = InstanceTest.instance();
        System.out.println(i1 == i2); //true
    }
}
