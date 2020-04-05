package com.jokey.search;

/**
 * @ClassName: BinarySearch
 * @author: Jokey Zhou
 * @date: 2020/4/5 18:55
 * @description: 二分查找(递归版本)
 * 思路：
 * 1.给定一个有序的数组arr
 * 2.设定一个数组中间值mid，将其位置所在的值和需要查找的target进行比较
 * 3.如果arr[mid]值比target大，那么就向左递归查找，反之向右
 *
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class BinarySearch1 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1000));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 0));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1234));
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        // 给出递归的出口
        if (left > right) return -1;
        // 设置mid值
        int mid = left + (right - left) / 2;
        // 开始递归查找
        if (arr[mid] > target) {  // 当需要查找的值在中间值左边的时候
            // 向左边递归查找
            return binarySearch(arr, left, mid-1, target);
        } else if (arr[mid] < target){  // 反之则向右递归查找
           return binarySearch(arr, mid+1, right, target);
        } else {
            return mid;
        }
    }
}
