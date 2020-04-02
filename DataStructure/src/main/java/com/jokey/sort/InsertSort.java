package com.jokey.sort;

import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @Description: 插入排序
 * 思路如下：
 * 把n个待排序的元素看成一个有序表和一个无序表，
 * 最开始有序表中只包含一个元素，无序表中包含有(n-1)个元素
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将其插入适当的位置
 * 最后就可以得到有序的排序表
 *
 * 插入排序的时间复杂度O(n^2)
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/2 10:15
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 85 ,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        /*
        // 依旧是逐步分解来找规律
        // 第一轮循环
        int insertVal = arr[1];  // 从无序数组中取出第一个元素
        int insertIdx = 1 -1;  // 需要插入的位置先假定为有序数组的最后一个位置
        // 索引大于等于0防止数组越界，待插入值和索引所在位置的值进行比较，如果待插入值比索引值位置的值小，就继续找
        while (insertIdx >= 0 && insertVal < arr[insertIdx]) {
            arr[insertIdx + 1] = arr[insertIdx];
            insertIdx--;
        }
        arr[insertIdx + 1] = insertVal;
        System.out.println(Arrays.toString(arr));

        // 第二轮循环
        int insertVal2 = arr[2];
        int insertIdx2 = 2 -1;
        while (insertIdx2 >= 0 && insertVal2 < arr[insertIdx2]) {
            arr[insertIdx2 + 1] = arr[insertIdx2];
            insertIdx2--;
        }
        arr[insertIdx2 + 1] = insertVal2;
        System.out.println(Arrays.toString(arr));
         */

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];  // 取出待排序的数字
            int insertIdx = i - 1;  // 插入的下标为待排序数字的前一位
            while (insertIdx >= 0 && insertVal < arr[insertIdx]) {
                arr[insertIdx + 1] = arr[insertIdx];
                insertIdx--;
            }
            arr[insertIdx + 1] = insertVal;
        }
    }
}
