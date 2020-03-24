package com.jokey.linkedlist;

import java.util.LinkedList;

/**
 * @ClassName: DoubleLinkedList
 * @Description: 双向链表的增删查
 * @Author: Jokey Zhou
 * @Date: 2020/3/24 11:15
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

// 定义一个双向链表的节点类
class DoubleNode {
    public int val;
    public DoubleNode pre;  // 指向前一个节点的指针
    public DoubleNode next;  // 指向后一个节点的指针

    public DoubleNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "val=" + val +
                '}';
    }
}

// 双向链表的增删改查等操作
class DoubleLinkedList {
    private DoubleNode head = new DoubleNode(0);  // 该节点为双向链表头结点 不可移动

    // 返回头节点
    public DoubleNode getHead() {
        return head;
    }

    // 添加一个节点到链表最后
    public void addEle(DoubleNode node) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) break;
            else {
                temp = temp.next;
            }
        }
        temp.next = node;
        node.pre = temp;
    }

    // 双向链表的遍历
    public void show() {
        // 当双向链表头结点的下一个节点为空时 表示链表为空 直接return
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 当双向链表不为空时
        DoubleNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 双向链表的修改和单向链表相同(SingleLinkedListMain)，此处不再重复

    // 双向链表删除节点（重点！）
    public void deleteEle(int num) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 当链表不为空时
        DoubleNode temp = head.next;  // 设置一个辅助节点
        boolean flag = false;  // 设置一个flag用于判断是否找到需要删除的节点
        while (true) {
            if (temp == null) {  // 遍历到最后一个节点时 跳出循环
                break;
            }
            if (temp.val == num) {  // 找到该节点了 将flag置为true 跳出循环
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            // 当需要删除的节点在链表中时
            // 1.将该节点前一个节点的指针指向该节点的下一个节点
            temp.pre.next = temp.next;

            // 2.将该节点下一个节点的指针指向该节点上一个节点
            // 但需要注意的是 此处要考虑如果该节点是最后一个节点 则不能这么做 会导致空指针异常
            // 所以需要加一层if判断 如果该节点不是最后一个节点 那么可以执行下面的代码
            if (temp.next != null) temp.next.pre = temp.pre;
        } else {
            System.out.println("需要删除的节点不存在");
        }
    }
}

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addEle(doubleNode1);
        doubleLinkedList.addEle(doubleNode2);
        doubleLinkedList.addEle(doubleNode3);
        doubleLinkedList.addEle(doubleNode4);

        doubleLinkedList.deleteEle(1);
        doubleLinkedList.deleteEle(4);

        // 遍历打印双向链表
        doubleLinkedList.show();
    }
}
