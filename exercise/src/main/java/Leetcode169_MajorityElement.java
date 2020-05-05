/**
 * @ClassName: Leetcode169_MajorityElement
 * @Description:
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/5 18:30
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode169_MajorityElement {

    public static int majorityElement(int[] nums) {
        // 这道题也是固定套路题，解题思路：
        // 首先初始化一个计数器，值为1
        // 初始化一根移动指针，在第一个位置上
        // 指针从左往右走，遇到相同的数则计数器+1
        // 遇到不同的数则-1，当为0时，则取下一个数作为基准数
        // 最后那个基准数就是需要找的数字

        // 给出基准数
        int num = nums[0];
        // 给出计数器
        int counter = 1;
        for (int i=1; i<nums.length; i++) {
            if (num == nums[i]) {
                counter ++;
            } else {
                counter --;
                if (counter == 0) {
                    num = nums[i+1];
                }
            }
        }
        return num;
    }
}
