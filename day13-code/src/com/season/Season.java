package com.season;

/**
 * 季节枚举
 */

public  enum Season {
    // 第一行列出所有的枚举实例，一般用大写
    SPRING/*调用无参数构造器*/, SUMMER, AUTUMN("秋天")/*调用有参数构造器*/, WINTER("冬天");
    // 定义成员变量
    private  String desc;
    // 定义类变量
    static  String name= "季节";
    // 定义类方法
    public static void test(){
        System.out.println("枚举的类方法");
    }
    // 定义枚举无参数构造器，使用private修饰
    Season(){ }
    // 定义枚举有参数构造器，使用private修饰
    Season(String desc){
        this.desc = desc;
    }

    /**
     * 重写toString
     * @return 枚举的描述
     */
    @Override
    public String toString(){
        return "Season [desc="+this.desc + "]";
    }

    // 定义实例方法
    public  void info() {
        switch (this){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }


}
