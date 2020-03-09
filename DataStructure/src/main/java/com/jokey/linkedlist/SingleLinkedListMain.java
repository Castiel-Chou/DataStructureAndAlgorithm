package com.jokey.linkedlist;

/**
 * @ClassName: SingleLinkedListMain
 * @Description: 单向链表实现增删改查
 * @Author: Jokey Zhou
 * @Date: 2020/3/9 10:31
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

/**
* @Description: 节点类 用于定义节点信息
* @Author: Jokey Zhou
* @Date: 2020/3/9
*/
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

/**
* @Description: 单向链表节点 提供增删改查等方法
* @Author: Jokey Zhou
* @Date: 2020/3/9
*/
class SingleLinkedList {
    // 首先创建一个头结点 该节点不存储数据
    private HeroNode head = new HeroNode(0,"","");

    /**
     * ① 不考虑编号顺序时 向单向链表添加节点
     * @param hero
     */
    public void add(HeroNode hero) {
        /**
         * 思路：
         * 1.找到链表的最后
         * 2.将最后这个节点的next指针指向新添加的这个节点
         * 3.因为头结点不能动 因此定义一个辅助节点作为指针来遍历单向链表
         */
        HeroNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = hero;
    }

    /**
     * 根据编号的顺序将节点插入链表中
     * @param hero
     */
    public void addByOrder(HeroNode hero) {
        HeroNode tmp = head;  // 首先创建一个辅助节点来遍历链表
        Boolean flag = false; // 创建一个标志 用来判断添加的这个节点是否已经在链表中存在

        while (true) {
            if (tmp.next == null) break;  // 情况一：tmp指针已经在链表尾
            if (tmp.next.no > hero.no) {  // 情况二：找到了需要插入的位置 即当前节点的前一个位置
                break;
            } else if (tmp.next.no == hero.no) {  // 情况三：存在和插入的节点编号相同的节点
                flag = true;
                break;
            }
            tmp = tmp.next;
        }

        if (flag) {
            System.out.println("该节点已存在: " + hero.no);
        } else {
            hero.next = tmp.next;
            tmp.next = hero;
        }
    }

    /**
     * 展示链表
     */
    public void show() {
        // 当链表为空时 直接返回
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode tmp = head.next;
        while (true) {
            // 当遍历到最后一个节点时 跳出while循环
            if (tmp == null) break;
            // 循环遍历节点输出节点信息
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
}

public class SingleLinkedListMain {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "a", "AAA");
        HeroNode heroNode2 = new HeroNode(2, "b", "BBB");
        HeroNode heroNode3 = new HeroNode(3, "c", "CCC");
        HeroNode heroNode4 = new HeroNode(3, "c", "CCC");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.show();
    }
}

