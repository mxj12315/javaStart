package min.singleinstance;


/**
 * 单利模式
 */
public class InstanceTest {
    private static  InstanceTest s;

    /**
     * 隐藏的构造器
     */
    private InstanceTest(){}

    public static InstanceTest instance(){
        // s 为null 则创建实例
        if(s==null){
            s = new InstanceTest();
        }

        return s;
    }
}
