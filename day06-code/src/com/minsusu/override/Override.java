package com.minsusu.override;

/**
 * 方法重写
 */
public class Override {
    public static void main(String[] args){
        // 向上转型
        Animal a1 =new Cat();
        Animal a2 =new Dog();   // 运行期引用的是Dog类的实例对象
        a1.run();  // 猫轻轻的跑
        a2.run();  // 小狗跳着跑

        // a2.eat();  // 虽然小狗类中有eat方法，但是编译期认为a2是Animal类，所有a2调用eat方法报错！  使用反射可以调用
        // 如果a2是Animal类的之类创建的对象，那么执行强制类转换
        if (a2 instanceof Animal){
            // 将Animal向下强制转换为Dog类
            Dog dog = (Dog) a2;
            dog.eat();
        }

//        String str= "kfmkm";
//        System.out.println(str instanceof Integer);
    }

}
