package com.jokey.sort;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: 归并排序
 * 思路：
 * 归并排序是经典算法“分治法”的实际应用场景之一
 * 首先将待排序数组不停的折半拆分，一直拆到每个组里面只剩一个元素
 * 接下来，将每个元素按照分组放入一个临时数组中(这里理解起来比较抽象，举例来看)
 *
 * 假设我们有一个数组[8, 4, 5, 7, 1, 3, 6, 2]，经过折半拆分
 * 8457, 1362
 * 84, 57, 13, 62
 * 8, 4, 5, 7, 1, 3, 6, 2
 * ===============================
 * 开始合并
 * 48, 57, 13, 26
 * 4578, 1236
 * 12345678
 *
 * 以上的过程就是归并排序法
 * 我们选取最后一次的排序来理清代码思路：
 * 现在有两个有序子序列[4,5,7,8]和[1,2,3,6]，需要将两个子序列中的数字按大小存入一个临时数组中
 * 1.设置一个指针i来遍历第一个子序列
 * 2.设置一个指针j来遍历第二个子序列
 * 3.循环的时候将arr[i]和arr[j]比大小，小的就进入临时数组
 * 4.当其中一个序列全部进入临时数组后，将另一个序列中剩下的全部放入临时数组的最后
 * 5.将临时数组拷贝到arr中
 * 上面的5步即为合并的思路
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/3 16:16
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge (int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 初始化第一个子序列的索引
        int j = mid + 1;  // 初始化第二个子序列的索引
        int idx = 0;  // 初始化临时数组的索引

        // 两根指针开始同时从左向右扫
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {  // 当第一个子序列中的数比第二个子序列中的数字小
                temp[idx] = arr[i];  // 将第一个子序列中的数字放入临时数组中 并且索引后移
                idx ++;
                i ++;
            } else {
                temp[idx] = arr[j];
                idx ++;
                j ++;
            }
        }

        // 到这里表示至少已经有一个子序列中的数字全部都放入临时数组了
        // 那么此时需要将另外一个子序列中剩下的数字全部放入临时数组中
        while (i <= mid) {
            temp[idx] = arr[i];
            i ++;
            idx ++;
        }
        while (j <= right) {
            temp[idx] = arr[j];
            idx ++;
            j ++;
        }

        // 到此处表示已经将两个子序列中所有的数字按照从小到大的顺序装入了临时数组
        // 此时再将临时数组中的数字复制到原始数组中
        idx = 0;  // 重置临时数组的索引
        int leftIdx = left;  // 重置原始数组的索引
        while (leftIdx <= right) {
            arr[leftIdx] = temp[idx];
            leftIdx ++;
            idx ++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 先拆左边部分
            mergeSort(arr, left, mid, temp);
            // 再拆右边部分
            mergeSort(arr, mid+1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }
}
