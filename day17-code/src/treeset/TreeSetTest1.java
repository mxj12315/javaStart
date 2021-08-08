package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet自然排序
 */
public class TreeSetTest1 {
    public static void main(String[] args) {
        Goat goat1 = new Goat("黑色",45.3);
        Goat goat2 = new Goat("黑色",35.8);
        Set<Goat> set =new TreeSet<>();
        set.add(goat1);
        set.add(goat2);
        System.out.println(set);

    }
}

class Goat implements Comparable<Goat>{
    private final String color;
    private final double weight;

    /**
     * 如果当前对象大于要比较的对象，返回正整数
     * 如果当前对象小于要比较的对象，返回负整数
     * 如果当前对象等于要比较的对象，返回0
     * @param target 要比较的对象
     * @return 正整数 or 负整数 or 0
     */
    @Override
    public int compareTo(Goat target) {
        return Double.compare(this.weight, target.weight);
    }

    public Goat(String color, double weight){
        this.weight =weight;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Goat [color="+color+"]"+"[weight="+weight+"]";
    }
}
