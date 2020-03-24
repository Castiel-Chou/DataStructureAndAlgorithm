package com.jokey.linkedlist;

/**
 * @ClassName: LinkedListTest1
 * @Description: 求单链表的有效节点个数(不考虑新增头结点的情况)
 * @Author: Jokey Zhou
 * @Date: 2020/3/13 11:13
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

class Node {  // 定义节点类
    int val;
    Node next;
    Node(int x){val = x;}

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

public class EffectiveNodeNums {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new EffectiveNodeNums().getLength(node1));
    }

    /**
     * 单链表的有效节点个数
     * @param head 传入的第一个结点(可以为带头结点，或者直接传入第一个节点)
     * @return 有效节点数
     */
    public int getLength(Node head) {
        // 若需要考虑增加头结点 则此处的head == null 应该为 head.next == null;
        if (head == null) return 0;  // 空链表

        // 若考虑头结点 则此处的tmp赋值应相应的改为 Node tmp = head.next;
        Node tmp = head;  // 定义一个辅助节点
        int num = 0;
        while (tmp != null) {
            num++ ;
            tmp = tmp.next;
        }
        return num;
    }
}
