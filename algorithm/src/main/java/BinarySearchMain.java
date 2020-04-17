/**
 * @ClassName: BinarySearchMain
 * @Description: 二分查找算法的非递归实现
 * @Author: Jokey Zhou
 * @Date: 2020/4/13 14:52
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class BinarySearchMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        System.out.println(BinarySearchMain.binarySearch(arr, 0));
        System.out.println(BinarySearchMain.binarySearch(arr, 1));
        System.out.println(BinarySearchMain.binarySearch(arr, 3));
        System.out.println(BinarySearchMain.binarySearch(arr, 8));
        System.out.println(BinarySearchMain.binarySearch(arr, 10));
        System.out.println(BinarySearchMain.binarySearch(arr, 12));
        System.out.println(BinarySearchMain.binarySearch(arr, 11));
        System.out.println(BinarySearchMain.binarySearch(arr, 67));
        System.out.println(BinarySearchMain.binarySearch(arr, 100));
        System.out.println(BinarySearchMain.binarySearch(arr, 146));
    }

    public static int binarySearch(int[] arr, int target) {
        // 定义头指针
        int left = 0;
        // 定义尾指针
        int right = arr.length - 1;
        // 开始进行二分查找
        while (left <= right) {  // 细节一：<= 左指针直到与右指针重合才停止
            // 定义中间节点指针
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
