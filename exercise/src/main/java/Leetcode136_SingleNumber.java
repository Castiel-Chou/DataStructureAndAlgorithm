/**
 * @ClassName: Leetcode136_SingleNumber
 * @Description:
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/28 16:17
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode136_SingleNumber {

    public static int singleNumber(int[] nums) {
        // 这道题考察的是对于异或操作符的理解
        // 1. a ^ b ^ c <=> a ^ c ^ b
        // 2. 0 ^ n => n
        // 3. n ^ n => 0
        // 上面三条定理可以解得此题
        // 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
        int target = 0;  // 初始化需要找的那个数
        for (int i : nums) {
            target ^= i;
        }
        return target;
    }
}
