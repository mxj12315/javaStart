package com.ArrayDequeTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 双端队列，既是栈，又是队列
 */
public class ArrayDequeTestQueue {

    public static void main(String[] args) {
        Deque<String> deque =new ArrayDeque<>();
        // 入队,先进先出
        deque.offer("猪八戒");
        deque.offer("孙悟空");
        deque.offer("牛魔王");
        deque.offer("红孩儿");
        // 出队
        System.out.println(deque.poll()); // 猪八戒
        System.out.println(deque.poll());  // 孙悟空

        // 获取队头的圆度，但并不出队
        System.out.println(deque.peek());  // 牛魔王
        System.out.println(deque.peek());  // 牛魔王

    }
}
