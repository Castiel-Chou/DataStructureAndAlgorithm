package com.jokey.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BinarySearch2
 * @author: Jokey Zhou
 * @date: 2020/4/5 21:15
 * @description: 二分查找2
 * 问题描述：
 * 有一个已经从小到大排序的数组{1, 8, 10, 89, 1000, 1000, 1000, 1234}
 * 请使用二分查找的思想，找出该数组中值为1000的所有下标
 *
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        // 递归出口
        if (left > right) {
            return new ArrayList();
        }

        // 查找的思路和普通二分查找类似
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            return binarySearch2(arr, left, mid-1, target);
        } else if (arr[mid] < target) {
            return binarySearch2(arr, mid+1, right, target);
        } else {
            // 当找到了这个目标值 此时并不直接返回
            // 而是向左和向右进行相同值的查找
            // 新建一个可变数组用于存放返回的下标
            List<Integer> idxArr = new ArrayList<>();

            int tmp = mid - 1; // 先设置一个临时指针，从目标值向左遍历
            while (true) {
                if (tmp < 0 || arr[tmp] != target) {
                    // 上面两个条件表示已经向左遍历完了或者遍历到已经和目标值不同的数字了
                    break;
                }
                idxArr.add(tmp);
                tmp --;
            }

            idxArr.add(mid);  // 在此处将mid加入可以保证返回的结果是按从小到大的顺序排列

            // 然后将临时指针设置为目标值右边，开始向右扫
            tmp = mid + 1;
            while (true) {
                if (tmp > arr.length-1 || arr[tmp] != target) {
                    // 当指针扫完数组最后一个值或者不等于目标值了
                    break;
                }
                idxArr.add(tmp);
                tmp ++;
            }
            return idxArr;
        }
    }
}
