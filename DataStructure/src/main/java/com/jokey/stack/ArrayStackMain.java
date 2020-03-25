package com.jokey.stack;

import java.util.Scanner;

/**
 * @ClassName: ArrayStackMain
 * @Description: 使用数组实现栈的添加和取出
 * @Author: Jokey Zhou
 * @Date: 2020/3/25 17:24
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
// 定义栈的类
class ArrayStack {
    private int size;  // 栈的容量
    private int[] stack;  // 使用数组模拟栈结构
    private int top = -1;  // 这个指针表示栈顶的位置

    // 定义构造器，用于初始化栈
    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
    }

    // 判断栈是否空
    public boolean isEmpty() {
        return top == -1;
    }

    // 判断栈是否满
    public boolean isFull() {
        return top == size - 1;
    }

    // 入栈
    public void push(int num) {
        if (isFull()) throw new RuntimeException("栈已经满了，无法添加元素");
        top ++;
        stack[top] = num;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) throw new RuntimeException("栈已经空了，无法取出元素");
        int value = stack[top];
        top --;
        return value;
    }

    // 遍历栈数据，从栈顶到栈底进行遍历
    public void show() {
        if (isEmpty()) throw new RuntimeException("栈是空的");
        for (int i=top; i>=0; i--) {
            System.out.println(stack[i]);
        }
    }
}

public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":

                    try {
                        stack.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    try {
                        stack.push(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
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
