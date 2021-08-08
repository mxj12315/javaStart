package com.maptest;

import java.util.*;
import java.util.function.BiConsumer;


/**
 * V put(K key, V value) 将指定的值与此映射中的指定键关联（可选操作）。
 * Set<Map.Entry<K,V>>	entrySet() 返回此映射中包含的映射关系的 Set 视图。
 *  Collection<V>	values() 返回此映射中包含的值的 Collection 视图。
 *   Set<K>	keySet() 返回此映射中包含的键的 Set 视图。
 *
 */
public class HashMapTest0 {
    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<>();
        // 添加键值对
        m.put(1,"语文");
        m.put(2,"数学");
        m.put(3,"英语");
        m.put(4,"化学");
        m.put(5,"物理");
        m.put(5,"政治");  // 会覆盖前面的
        // 获取制定key的value
        String ss = m.get(3);
        System.out.println(ss);
        // 删除元素
        m.remove(5);

        // 遍历所有的value
        Collection<String> S1 = m.values();
        for (String data:S1) {
            System.out.println(data);
        }

        // 是否包含某个key
        boolean x = m.containsKey(4);
        System.out.println("是否包含4这个key："+x);

        // 是否包含某个value
        boolean y = m.containsValue("物理");
        System.out.println("是否包含 物理在这个value ："+y);


        // 循环遍历
        // 1、使用迭代器遍历
        Set<Integer> keys= m.keySet();  // 返回Set集合
        Iterator<Integer> PP=keys.iterator();  // 创建迭代器
        while (PP.hasNext()){
            Integer key = PP.next();
            String value  = m.get(key);
            System.out.println("键："+key+"--值："+value);

        }
        //2、使用foreach
        for (Integer key:m.keySet()) {
            System.out.println("键"+key+"值："+m.get(key));
        }

        //3、使用entrySet
        Set<Map.Entry<Integer,String>> s =  m.entrySet();
        Iterator<Map.Entry<Integer,String>> it = s.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("键："+key+",值："+value);
        }

        // 4 使用for循环遍历
        for (Iterator<Integer> i= m.keySet().iterator(); i.hasNext() ;){
            Integer key = i.next();
            System.out.println("kye是："+
                    key + "value: " + m.get(key));
        }
        System.out.println("5 使用forEach方法遍历");
        // 5 使用forEach方法遍历
        m.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer key, String value) {
                System.out.println("键："+key+"--值："+value);
            }
        });
        System.out.println("6 使用forEach方法遍历 lambda表达式");
        //  6 使用forEach方法遍历 lambda表达式
        m.forEach((key,value)-> System.out.println("键："+key+"--值："+value));

    }
}
