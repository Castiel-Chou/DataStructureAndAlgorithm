/**
 * @ClassName: Leetcode9_IsPalindrome
 * @Description:
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/6/10
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode9_IsPalindrome {

    /**
     * 思路：
     * 这道题的思路是比较简单的 首先排除负数 因为负数根据题意必定不是回文数
     * 然后只需要做循环，将数字翻转，判断翻转后的数字和原输入是否相同即可
     *
     * @param x
     * @return
     */

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int newNumber = 0;
        int tmp = x;
        while (x != 0) {
            int a = x % 10;
            newNumber = newNumber * 10 + a;
            x /= 10;
        }

        return newNumber == tmp;

    }
}
