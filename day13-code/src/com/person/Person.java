package com.person;

/**
 * 人类枚举
 */
public enum Person {
    // 枚举的所有实例：男人，女人
    MEN(){/*调用无参的构造器,省略小括号*/
        // 匿名内部类的类体
        @Override
        public void info(){
            System.out.println("这是男人的info方法");
        }
    },

    WOMEN("女人"){
        @Override
        public void info(){
            System.out.println("这是女人的info方法");
        }
    };
    // 实例变量
    private String desc;

    // 无参数构造器
    Person(){};

    // 带参数构造器
    Person(String desc){
        this.desc = desc;
    };
    // 抽象方法
    abstract void info();

    // get方法
    public String getDesc(){
        return this.desc;
    }
}
