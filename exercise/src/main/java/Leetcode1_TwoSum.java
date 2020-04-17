import java.util.HashMap;

/**
 * @ClassName: Leetcode1_TwoSum
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/15 15:03
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 获取目标值和nums[i]的差值
            int n = target - nums[i];
            // 如果在map中存在 说明数组中可以取出两个数相加得到target值
            if (map.containsKey(n)) {
                // 返回n对应的数组下标，和本次循环的数组下标
                return new int[]{map.get(n), i};
            }
            // 如果本轮循环没有找到，则将nums[i]和对应的数组下标加入HashMap中
            map.put(nums[i], i);
        }
        // 若都没有找到 直接抛出异常
        throw new RuntimeException("No result!");
    }
}
