import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Leetcode448_FindDisappearedNumbers
 * @Description:
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/20 11:26
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode448_FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        disappearedNumbers.forEach(System.out::println);
    }

    /**
     * 思路“
     * 1. 循环数组，将里面的每个数字作为数组下标，将对应位置上的数置为负数
     * 2. 由于存在重复的数字，所以要先判断这个位置上的数字是否大于0，大于0时才做反转操作
     * 3. 在处理过程中，要将每个位置上的数字先取绝对值
     * 4. 在一次循环之后，再做一次数组遍历，选出位置上为0的下标，加入ArrayList
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> arr = new ArrayList<>();
        // 将数组中的每一个元素作为下标，将对应位置上的数置为负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }

        // 循环遍历数组，只要为整数的，加入arr
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) arr.add(i+1);
        }

        return arr;
    }
}
