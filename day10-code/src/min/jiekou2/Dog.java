package min.jiekou2;

public class Dog implements Eatable, Moveable{
    @Override
    public void eat(){
        System.out.println("狗吃东西");
    }

    @Override
    public void run(){
        System.out.println("狗在跑");
    }

    public void test(){
        System.out.println("Dog的test方法");
    }
    public static void main(String[] args) {
        // 向上转型
        Eatable dog =new Dog();
        dog.eat();
        if (dog instanceof Dog){
            Dog d = (Dog) dog;
            d.run();
        }




    }
}
