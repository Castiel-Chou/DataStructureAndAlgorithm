package com.jokey.linkedlist;

/**
 * @ClassName: JosephuProblem
 * @Description: 约瑟夫环问题
 * 描述：设编号为1,2,3...n的n个小孩围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数
 * 数到m的那个人出列，它的下一位又从1开始报数，数到m的人再出列，以此类推，直到所有人出列为止
 * 请根据此求出一个出队的编号序列
 *
 * 思路：用一个不带头节点的循环链表来解决此问题,首先构成一个有n个节点的单循环链表，然后由k节点起从1开始计数，
 * 计到m时，将该对应的节点从链表中删除，然后再从被删除节点的下一个节点又从1开始计数，
 * 直到最后一个节点从链表中删除为止
 * @Author: Jokey Zhou
 * @Date: 2020/3/25 10:06
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

// 先创建一个孩子的类 包含孩子的编号和指针信息
class Child {
    private int no;
    private Child next;

    public Child(int no) {
        this.no = no;
    }

    public void setNext(Child next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public Child getNext() {
        return next;
    }
}

// 单向循环链表类
class CircleSingleLinkedList {
    private Child head;  // 定义一个头节点

    /**
     * 该方法的作用是向单循环链表中添加节点 形参num表示需要添加几个节点
     * @param num  需要添加的节点数量
     */
    public void addEle(int num) {
        // 首先需要判断的是如果输入的num小于1是不合法的 因为至少需要一个节点
        if (num < 1) {
            System.out.println("输入的参数不合法");
            return;
        }

        Child curChild = null;  // 设定一个辅助指针进行遍历
        for (int i=1; i<=num; i++) {
            Child child = new Child(i);  // 根据编号 创建小孩节点
            if (i == 1) {  // 当添加第一个节点时
                head = child;  // 头结点为当前创建的新的第一个节点
                head.setNext(head);  // 当前节点的下一个节点指向自己
                curChild = head;  // 辅助指针指向当前的头节点
            } else {  // 之后再有新的节点加入
                curChild.setNext(child);
                child.setNext(head);
                curChild = child;
            }
        }
    }

    /**
     * 遍历单向环形链表
     */
    public void show() {
        // 首先判断该链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        // 单链表不为空时 需要一个辅助指针来循环遍历链表
        // 需要注意的是循环结束条件 只有在当前节点的下一个节点指向头节点的时候 则表示当前节点是最后一个节点了 循环结束
        Child curChild = head;
        while (true) {
            System.out.println("Child: " + curChild.getNo());
            if (curChild.getNext() == head) {  // 表示已经遍历到了最后一个节点
                break;
            }
            curChild = curChild.getNext();
        }

    }

    /**
     * 打印小孩出圈的顺序，思路如下：
     * 1.定义一个tail指针，指向链表中最后一个位置
     * 2.将tail指针和head指针同时移动(k-1)个位置，确保是从第k个位置开始数的
     * 3.将两根指针再同时移动(m-1)次 此时head指向的就是需要出圈的节点
     * 4.此时将head指针向下走一个位置 再将tail指针的next指向head节点
     * head = head.next;
     * tail.next = head;
     * 5.这两步之后，需要出圈的节点没有任何引用指向它，会被当做垃圾回收
     * 6.重复以上步骤，就可以得到出圈的顺序
     *
     * @param k  从第k个位置开始数
     * @param m  一直数到第m个位置，该位置出圈
     * @param totalChildren  总共有多少个孩子围成这个圈
     */
    public void deQueue(int k, int m, int totalChildren) {
        // 首先判断一下输入的参数是否合法
        if (k < 1 || k > totalChildren || m < 1 || totalChildren < 1 || head == null) {
            System.out.println("输入的参数不合法");
            return;
        }

        // 定义一个尾指针 指向链表的尾部
        Child tail = head;
        while (true) {
            if (tail.getNext() == head) {
                break;
            }
            tail = tail.getNext();
        }

        // 将tail指针和head指针同时移动(k-1)个位置
        for (int i=1; i<= (k-1); i++) {
            head = head.getNext();
            tail = tail.getNext();
        }

        // 将两根指针同时移动(m-1)次,
        // 此时将head指针向下走一个位置 再将tail指针的next指向head节点
        // 直到tail == head 说明此时链表中只剩最后一个节点了 将其输出
        while (true) {
            if (head == tail) {
                System.out.println(head.getNo());
                break;
            }

            for (int i=1; i<=(m-1); i++) {
                head = head.getNext();
                tail = tail.getNext();
            }
            System.out.print(head.getNo() + "--->");
            head = head.getNext();
            tail.setNext(head);
        }
    }
}

public class JosephuProblem {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addEle(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.deQueue(2,3,5);
    }
}
