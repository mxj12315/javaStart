package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet定制排序
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        Goat1 goat1 = new Goat1("黑色",45.3);
        Goat1 goat2 = new Goat1("白色",35.8);
        // 使用匿名内部类的写法
//        Set<Goat1> set =new TreeSet<>(new Comparator<Goat1>() {
//
//            /**
//             * 如果当前对象大于要比较的对象，返回正整数
//             * 如果当前对象小于要比较的对象，返回负整数
//             * 如果当前对象等于要比较的对象，返回0
//             */
//            @Override
//            public int compare(Goat1 o1, Goat1 o2) {
//                return o1.getWeight() > o2.getWeight() ? 1: (o1.getWeight() < o2.getWeight() ? -1:0);
//            }
//        });
        Set<Goat1> set =new TreeSet<>((o1, o2) ->
              o1.getWeight() > o2.getWeight() ? 1: (o1.getWeight() < o2.getWeight() ? -1:0) );
        set.add(goat1);
        set.add(goat2);
        System.out.println(set);

    }
}

class Goat1 {
    private final String color;
    private final double weight;


    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Goat1(String color, double weight){
        this.weight =weight;
        this.color = color;
    }


    @Override
    public String toString(){
        return "Goat [color="+color+"]"+"[weight="+weight+"]";
    }
}
