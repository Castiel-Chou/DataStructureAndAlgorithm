/**
 * @ClassName: Leetcode283_MoveZeros
 * @Description:
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/17
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode283_MoveZeros {

    /**
     * 这道题的思路为：
     * 1. 首先将所有非零的数按次序从数组index为0开始填充
     * 2. 将数组剩下位置全部填充0即可
     * 3. 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param nums
     */

    public static void moveZeros(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count ++;
            }
        }

        for(int j=count; j<nums.length; j++) {
            nums[j] = 0;
        }
    }
}
