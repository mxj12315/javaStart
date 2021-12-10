package 注解测试;

public class MethodTest {
    @Test
    public void test1() {
        System.out.println("测试1");
    }

    @Test
    public void test2() {
        System.out.println("测试2");
        throw new IllegalArgumentException("测试2异常");
    }

    @Test
    public void test3() {
        System.out.println("测试3");
    }

    @Test
    public void test4() {
        System.out.println("测试4");
        throw new IllegalArgumentException("测试4异常");
    }

    public void test5() {
        System.out.println("测试5");
    }
}
