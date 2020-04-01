package com.jokey.sort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序算法
 * 冒泡排序的主题思路：
 * 1.每次循环都将当前的数字和后面一位的数字进行比较，如果前面的数字比较大，那么就交换位置
 * 2.重复上面的操作
 * 3.第一次循环可以将最大的数字放在最后一位，第二次循环可以将倒数第二大的数字放在倒数第二位，以此类推...
 * 4.有一个优化点是当经过一次循环后，如果没有发生位置的变化，则说明已经排序完成，可以直接break
 *
 * 冒泡排序的平均时间复杂度为O(n^2)
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/1 11:07
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-3, 9, 1, 10, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        // 创建一个flag用于判断这轮循环是否有发生位置交换
        boolean flag = false;
        // 开始循环
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    // 当进入这个判断调价 说明发生了换位 将flag置为true
                    flag = true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
