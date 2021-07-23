package com.ArrayDequeTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 双端队列，既是栈，又是队列
 */
public class ArrayDequeTestStack {

    public static void main(String[] args) {
        Deque<String> queue =new ArrayDeque<>();
        // 压栈,先进去的放在最底层
        queue.push("猪八戒");
        queue.push("孙悟空");
        queue.push("牛魔王");
        queue.push("红孩儿");
        // 弹栈
        System.out.println(queue.pop()); // 红孩儿
        System.out.println(queue.pop());  // 牛魔王

        // 获取最上次的栈
        System.out.println(queue.peek());  // 孙悟空

    }
}
