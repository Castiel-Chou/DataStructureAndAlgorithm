package com.jokey.sort;

import java.util.Arrays;

/**
 * @ClassName: SelectSort
 * @Description: 选择排序
 * 思路(从小到大排序)：
 * 1.第一轮循环从arr[0]~arr[n-1]中找到最小的值，和arr[0]交换位置
 * 2.第二轮循环从arr[1]~arr[n-1]中找到最小的值，和arr[1]交换位置
 * 3.以此类推，一共循环 n-1轮
 * 4.此时的数组就是排序后的数组
 *
 * 选择排序平均时间复杂度O(n^2)
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/1 15:23
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {-3, 9, 1, 10, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // 可以采用逐步推导的方式来总结出最终的代码

        /*
        // 首先来第一轮循环
        int minIdx = 0;  // 假定最小值的下标为0
        int minVal = arr[minIdx];  // 假定最小值就是数组的第一个元素
        for (int i = minIdx+1; i < arr.length; i++) {
            if (minVal > arr[i]) {  // 如果当前的最小值比它后面一位大
                minIdx = i;  // 将最小值的下标重置
                minVal = arr[i];  // 将最小值重置
            }
        }
        // 这一轮循环过后 即可得到最小值和最小值的小标
        // 此处要判断这时的最小值是否就是当前的这个位置，如果不是，则换位，如果是，不用换位
        if (minIdx != 0) {
            arr[minIdx] = arr[0];
            arr[0] = minVal;
        }


        // 第一轮循环之后 开始第二轮
        int minIdx = 1;  // 此时最小值的下标为1
        int minVal = arr[minIdx];  // 假定最小值就是数组的第二个元素
        for (int i = minIdx+1; i < arr.length; i++) {
            if (minVal > arr[i]) {  // 如果当前的最小值比它后面一位大
                minIdx = i;  // 将最小值的下标重置
                minVal = arr[i];  // 将最小值重置
            }
        }
        // 第二轮循环过后 即可得到倒数第二的最小值和最小值的小标
        // 此处要判断这时的最小值是否就是当前的这个位置，如果不是，则换位，如果是，不用换位
        if (minIdx != 1) {
            arr[minIdx] = arr[1];
            arr[1] = minVal;
        }
        */

        // 经过上面的分析 可以写出以下代码
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            int minVal = arr[minIdx];
            for (int j = minIdx+1; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    minIdx = j;
                    minVal = arr[j];
                }
            }

            if (minIdx != i) {
                arr[minIdx] = arr[i];
                arr[i] = minVal;
            }
        }
    }
}
