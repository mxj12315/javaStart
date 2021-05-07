package min.AbstractTest1;

/**
 * 鸟类，继承抽象类动物
 */
public  class AbstractBird extends AbstractAnimal{

    @Override
    public void movie() {
        System.out.println("鸟儿在天上飞");
    }
}
