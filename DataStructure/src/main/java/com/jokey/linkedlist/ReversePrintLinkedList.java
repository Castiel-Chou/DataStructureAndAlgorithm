package com.jokey.linkedlist;

import java.util.Stack;

/**
 * @ClassName: ReversePrintLinkedList
 * @Description: 从尾到头打印单链表(利用栈先进后出的数据结构特性)
 * @Author: Jokey Zhou
 * @Date: 2020/3/24 10:24
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class ReversePrintLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reversePrint(node1);
    }

    public static void reversePrint(Node node) {
        if (node == null) return;  // 如果第一个节点就为空 说明为空链表 直接return
        Stack<Node> stack = new Stack<>();  // 初始化一个栈
        // 将所有的节点压入栈中
        while (node != null) {
            stack.add(node);
            node = node.next;  // 指针后移
        }
        // 循环输出栈中的节点 即反向输出单向链表
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
