package com.jokey.search;

/**
 * @ClassName: InsertValueSearch
 * @author: Jokey Zhou
 * @date: 2020/4/6 11:56
 * @description: 插值查找
 * 插值查找是在二分查找的基础上的进一步优化，使用的场景为：
 * 数据量较大，关键字分布比较均匀，例如{1,2,3,4,5,6,7,8,9,10}这种连续的数组
 *
 * 和二分查找唯一的不同点在于:
 * 1.对于求中值mid的公式不同
 * mid = left + (right - left) * (target-arr[left]) / (arr[right]-arr[left])
 *
 * 2.递归出口的条件(如果不加这个条件可能会造成数组越界)
 * if (left>right || target < arr[0] || target > arr[arr.length-1])
 *
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        // 代码不再实现
        // 只需将BinarySearch1中的mid公式和递归出口修改即可
    }
}
