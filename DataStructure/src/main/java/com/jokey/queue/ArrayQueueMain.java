package com.jokey.queue;

import java.util.Scanner;

/**
 * @author Jokey Zhou
 * @version 1.0
 * @date 2020/2/14 21:27
 * @description: 使用数组模拟队列
 * 该版本的缺点是: 数组使用一次之后便不能再次使用，即无法达到复用的目的
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class ArrayQueueMain {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);  // 接收一个字符
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    try {
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'g':  // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.queueHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':  // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {
    // 表示数组的最大容量
    private int arrayMaxCapacity;
    // 队列头
    private int head;
    // 队列尾
    private int tail;
    // 该数组用于存放数据, 模拟队列
    private int[] queueArr;

    // 创建队列的构造器
    public ArrayQueue (int maxCapacity) {
        queueArr = new int[maxCapacity];  //创建该数组队列
        arrayMaxCapacity = maxCapacity;  // 数组的最大容量
        head = -1;  // 队首的数组下标前一位
        tail = -1;  // 队尾的数组下标
    }

    // 判断队列是否满
    public boolean isFull() {
        // 当队尾的下标 = 数组最大容量-1 时，表示该队列已满
        return tail == arrayMaxCapacity - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == tail;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {  // 判断队列是否已满 若满则抛出异常
            throw new RuntimeException("The Queue is Full!!!");
        }

        // 如果队列未满 则将输入的数字加入队尾
        queueArr[++tail] = n;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        if (isEmpty()) {  // 如果队列为空 则抛出异常
            throw new RuntimeException("The Queue is Empty!!!");
        }

        // 若队列中有数据 则从队首取数据
        head ++;
        return queueArr[head];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 如果队列是空的
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty");
        }

        // 当队列中有数据时
        for (int i : queueArr) {
            System.out.println(i);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int queueHead() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
        }

        // 当队列中有数据时
        return queueArr[head +1];
    }

}
