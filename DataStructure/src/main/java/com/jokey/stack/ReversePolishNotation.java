package com.jokey.stack;

import java.util.Stack;

/**
 * @ClassName: PolandNotation
 * @Description: 逆波兰表达式的计算器实现（每个元素都是个位数）
 * 输入一个逆波兰表达式(即后缀表达式),使用栈(Stack)，计算其结果
 * 假设需要计算的表达式为 (3+4)*5-6，那么转换成后缀表达式为 3 4 + 5 * 6 -
 *
 * 思路分析：
 * 1.从左至右扫描，将3和4压入栈内
 * 2.遇到 + 运算符，弹出3和4(4为栈顶元素，3位次顶元素)，计算出3+4=7，将计算结果7压入栈内
 * 3.将5入栈
 * 4.遇到 * 操作符，弹出5和7，将计算结果再次压入栈内
 * 5.重复类似的操作，直到表达式的结束，得出最终计算结果返回即可
 *
 * @Author: Jokey Zhou
 * @Date: 2020/3/27 11:06
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String suffixExpr1 = "3 4 + 5 * 6 -";
        String suffixExpr2 = "4 5 * 8 - 60 + 8 2 / +";
        System.out.println(calculate(parseExpression(suffixExpr1)));
        System.out.println(calculate(parseExpression(suffixExpr2)));
    }

    // 定义一个方法，遍历表达式，并将其中每个元素存入数组中以便于后续的遍历取出
    public static String[] parseExpression (String expr) {
        // 将字符串根据空格进行切分
        String[] exprArr = expr.split(" ");
        return exprArr;
    }

    // 定义计算表达式的方法
    public static int calculate(String[] expr) {
        Stack<String> stack = new Stack();  // 创建一个栈用于存放数字
        for (String ele : expr) {  // 遍历数组
            if (ele.matches("\\d+")) {  // 如果ele是数字的话 直接入栈
                stack.push(ele);
            } else {  // 如果遇到的是符号 将栈内的数字依次取出两个 进行计算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;  // 定义一个变量用于计算结果
                if (ele.equals("+")) {
                    result = num1 + num2;
                } else if (ele.equals("-")) {
                    result = num2 - num1;
                } else if (ele.equals("*")) {
                    result = num1 * num2;
                } else if (ele.equals("/")) {
                    result = num2 / num1;
                } else {
                    throw new RuntimeException("输入的符号有误");
                }
                stack.push(result + "");
            }
        }
        // 最后将栈内的唯一元素取出 就是计算所得的最终结果
        return Integer.parseInt(stack.pop());
    }
}
