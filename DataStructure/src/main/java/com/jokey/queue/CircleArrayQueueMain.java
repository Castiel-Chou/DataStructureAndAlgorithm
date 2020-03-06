package com.jokey.queue;

import java.util.Scanner;

/**
 * @ClassName: CircleArrayQueue
 * @Description: 数组模拟环形队列
 * @Author: Jokey Zhou
 * @Date: 2020/3/6 12:02
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class CircleArrayQueueMain {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("n(effective numbers): 队列有效数据个数");
            key = scanner.next().charAt(0);  // 接收一个字符
            switch (key) {
                case 's':
                    try {
                        circleArrayQueue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    try {
                        circleArrayQueue.enqueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':  // 取出数据
                    try {
                        int res = circleArrayQueue.dequeue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'n':
                    System.out.println("队列中有效数据个数： " + circleArrayQueue.effectiveNums());
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

class CircleArrayQueue {

    private int head;
    private int tail;
    private int maxSize;
    private int[] circleQueue;

    // 构造函数 初始化队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        circleQueue = new int[maxSize];
    }

    // 判断队列是否空
    public boolean isEmpty() {
        return head == tail;
    }

    // 判断队列是否满（重点记忆公式1）
    public boolean isFull() {
        return (tail +1) % maxSize == head;
    }

    // 入队
    public void enqueue(int n) {
        if (isFull()) {
            throw new RuntimeException("The Queue is Full");
        }
        circleQueue[tail] = n;
        tail = (tail +1) % maxSize;
    }

    // 出队
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty");
        }
        int val = circleQueue[head];
        head = (head +1) % maxSize;
        return val;
    }

    // 有效数据个数（重点记忆公式2）
    public int effectiveNums() {
        return (tail + maxSize - head) % maxSize;
    }

    // 显示队列数据
    public void show() {
        if (isEmpty()) throw new RuntimeException("The Queue is Empty");
        for (int i=head; i<head+effectiveNums(); i++) {
            System.out.println(circleQueue[i]);
        }
    }
}
