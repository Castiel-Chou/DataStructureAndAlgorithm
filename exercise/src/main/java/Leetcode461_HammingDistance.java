/**
 * @ClassName: Leetcode461_HammingDistance
 * @Description:
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/19 10:28
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode461_HammingDistance {

    /*
    解法一：直接使用内置方法，异或之后统计32位二进制的1的个数
     */
    public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /*
    解法二：先求出异或的结果，
     */
    public static int hammingDistance2(int x, int y) {
        int result = x ^ y;
        int counter = 0;
        while (result != 0) {
            if (result % 2 == 1) {
                counter ++;
            }
            result = result >> 1;
        }
        return counter;
    }


}
