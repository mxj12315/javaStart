package com.listTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * list集合
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("猪八戒");
        list.add("孙悟空");
        list.add("唐三藏");
        list.add("沙悟净");
        System.out.println(list);  //[猪八戒, 孙悟空, 唐三藏, 沙悟净]
        // 根据索引添加
        list.add(1,"太白金星");
        System.out.println(list);  // [猪八戒, 太白金星, 孙悟空, 唐三藏, 沙悟净]

        // 根据索引删除
        list.remove(1);
        System.out.println(list);  // [猪八戒, 孙悟空, 唐三藏, 沙悟净]

        // 根据索引修改
        list.set(3,"蜘蛛精");
        System.out.println(list);   // [猪八戒, 孙悟空, 唐三藏, 蜘蛛精]

        // 根据索引查询
        String el = list.get(0);
        System.out.println(el);  // 猪八戒

        // 获取元素的位置，不存在返回-1
        int index = list.indexOf("孙悟空");
        int _index = list.indexOf("123");
        System.out.println(index);  // 1
        System.out.println(_index);  // -1

        // 获取list的某一个部分
        List<String> subList = list.subList(1, list.size() - 1);
        System.out.println(subList); // [孙悟空, 唐三藏]
        System.out.println("// 遍历集合1 :通过索引下标");
        // 遍历集合1 :通过索引下标
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println("第"+ i +"个元素是： " + s);
            //第0个元素是： 猪八戒
            //第1个元素是： 孙悟空
            //第2个元素是： 唐三藏
            //第3个元素是： 蜘蛛精
        }
        System.out.println("// 遍历集合2 :通过forEach");
        // 遍历集合2 :通过forEach
        for (String e:list) {
            System.out.println("第"+list.indexOf(e)+"个元素是: " + e);
            // 第0个元素是: 猪八戒
            // 第1个元素是: 孙悟空
            // 第2个元素是: 唐三藏
            // 第3个元素是: 蜘蛛精
        }

        System.out.println("// 遍历集合3 :通过迭代器");
        // 遍历集合3 :通过迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("集合元素是: " + next);
            //集合元素是: 猪八戒
            //集合元素是: 孙悟空
            //集合元素是: 唐三藏
            //集合元素是: 蜘蛛精
        }

        System.out.println("// 遍历集合4 :通过forEach方法");
        // 遍历集合4 :通过forEach方法
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        });

        System.out.println("// 遍历集合5 :通过forEach方法,lambda表达式");
        // 遍历集合5 :通过forEach方法,lambda表达式
        list.forEach(s -> {
            System.out.println(s);
        });

        System.out.println("// 遍历集合6 :通过forEach方法,lambda表达式方法引用");
        // 遍历集合6 :通过forEach方法,lambda表达式方法引用
        list.forEach(System.out::println);

        // 判断是否包含某个对象
        boolean contains = list.contains("孙悟空");
        System.out.println(contains);


    }


}
