/**
 * @ClassName: Leetcode7_Reverse
 * @Description:
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/6/3 10:29
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode7_Reverse {

    /**
     * 思路：
     * 有一个很巧妙的思路 可以先将反转结果设置为long类型，最后强转为int类型
     * 如果强转之后结果一样，则没有溢出，直接返回
     * 如果结果不同，说明溢出，返回0
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int)res == res ? (int)res : 0;
    }
}
