package com.minsusu.toStringTest;

public class Apple {
    String color;
    double weight;

    public Apple(){

    }

    public Apple(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Apple:[color="+this.color+",weight="+this.weight+"]";
    }
}
