package com.jokey.sort;

import java.io.*;
import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * 思路如下：
 * 1.定义一个基准值，一般选取数组第一个的数字
 * 2.定义两根指针，左指针left和右指针right，用来做移动和判断
 * 3.从右往左移动右指针，当发现右指针所在位置的数字比基准数小的时候，停止移动
 * 4.从左往右移动左指针，当发现左指针所在位置的数字比基准数大的时候，停止移动
 * 5.此时两根指针都停止移动，交换两个数的位置
 * 6.继续上述的3~5步，直到两根指针相遇为止
 * 7.将基准值和指针相遇位置的值交换
 * 8.此时在基准值左边的数都比基准值小，在基准值右边的数都比基准值大
 * 9.用递归的思想，将基准值左边的数组用快排继续排序，然后再将基准值右边的数组也同样排序
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/3 10:08
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class QuickSort {
    public static void main(String[] args) throws IOException {
        int[] arr = {2, 10, 8, 22, 34, 5, 12, 28, 21, 11};

//        int[] arr = new int[10];
//        String num = null;
//        int i = 0;
//        File file = new File("C:\\Users\\chinadep\\IdeaProjects\\DataStructureAndAlgorithm\\DataStructure\\src\\main\\java\\com\\jokey\\sort\\sort_data.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        while ((num = br.readLine()) != null) {
//            arr[i] = Integer.parseInt(num);
//            i++;
//        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println("Spend: " + (end-start) + "ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 当左指针大于右指针时 return
        if (left > right) return;
        // 首先定义基准值
        int base = arr[left];
        // 接收左指针
        int i = left;
        // 接收右指针
        int j = right;
        // 当左右指针没有相遇时
        while (i != j) {
            // 右指针开始移动，当比基准值小的时候停止
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 左指针开始移动，当比基准值大的时候停下
            while (arr[i] <= base && i < j) {
                i++;
            }
            // 到这里表示两根指针都停下了 那么就交换两数的位置
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        // 到这里表示两根指针已经相遇 那么就交换基准值和指针所在位置的值
        arr[left] = arr[i];
        arr[i] = base;

        // 到此 比基准值小的数都在基准值左边 比基准值大的数都在基准值右边
        // 递归 先排左边
        quickSort(arr, left, i-1);
        // 再排右边
        quickSort(arr, i+1, right);
    }
}
