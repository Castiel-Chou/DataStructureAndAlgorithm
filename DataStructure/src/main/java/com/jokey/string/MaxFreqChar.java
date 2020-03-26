package com.jokey.string;

import java.util.Scanner;

/**
 * @ClassName: MaxFreqChar
 * @Description: 求字符串中出现次数最多的字符
 * 求任意给定字符串中出现次数最多的字符,如果出现最多次数的字符有多个，则只输出最先出现的字符。
 * 输入任意一个字符串（不超过100个字符）
 *
 * @Author: Jokey Zhou
 * @Date: 2020/3/26 14:59
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class MaxFreqChar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // 从键盘输入一串字符串
        String str = scanner.nextLine();  // 获取该字符串
        int[] nums = new int[200];  // 创建一个数组用于统计字符出现的次数

        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) != ' ') {  // 循环遍历该字符串的每一个字符 如果该位置上的字符不是空格
                nums[str.charAt(i)] ++;  // 那么就将该字符所在位置上的数字+1，这里的技巧是char类型可以转成数字运算
            }
        }

        // 上面的循环完毕之后 便可以得到一个带有统计字符次数的整形数组
        int max = -1;  // 设定一个最大值

        for (int i = 0; i <nums.length ; i++) {  // 循环遍历数组 得到最大值
            if (nums[i] > max) max = nums[i];
        }

        // 最后一步 根据得到的最大值 得出第一个出现次数最多的字符
        for (int i = 0; i <str.length() ; i++) {
            if (max == nums[str.charAt(i)]) {
                System.out.println(str.charAt(i));
                break;
            }
        }

    }
}
