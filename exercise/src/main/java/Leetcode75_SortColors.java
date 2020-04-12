/**
 * @ClassName: SortColors_Leetcode75
 * @author: Jokey Zhou
 * @date: 2020/4/12 21:59
 * @description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例：
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode75_SortColors {
    public static void main(String[] args) {
        // 这道题其实就是一道排序算法
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 定义递归的出口
        if (left > right) return;
        // 定义基准值
        int base = arr[left];
        // 定义左指针
        int i = left;
        // 定义右指针
        int j = right;
        // 两根指针开始移动 直到相遇为止
        while (i != j) {
            // right指针从右往左走 遇到比基准值小的停下
            while (arr[j] >= base && i<j) {
                j --;
            }
            // left指针从左往右走，遇到比基准值大的停下
            while (arr[i] <= base && i<j) {
                i ++;
            }

            // 此时交换arr[i]和arr[j]的位置
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        // 到这里表示两根指针已经相遇
        // 那么就交换基准值和arr[i]的值
        arr[left] = arr[i];
        arr[i] = base;

        // 这时基准值左边都是比基准值小的数
        // 基准值右边都是比基准值大的数
        // 开始递归左边和右边
        quickSort(arr, left, i-1);
        quickSort(arr, i+1, right);



    }
}
