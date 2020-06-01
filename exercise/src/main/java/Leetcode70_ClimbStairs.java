/**
 * @ClassName: Leetcode70_ClimbStairs
 * @Description:
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/6/1
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode70_ClimbStairs {

    /**
     * 思路：找规律
     * 当 n=1 时，只有一种方式
     * 当 n=2 时，可以一次爬一阶，也可以一次爬两阶，故有两种方法
     * 当 n=3 时，有三种方式(1，1，1/ 2,1 / 1,2)
     * 当 n=4 时，有五种方式(1,1,1,1/ 1,2,1/ 1,1,2/ 2,1,1/ 2,2)
     * 。。。
     *
     * 所以发现规律 f(n) = f(n-1) + f(n-2),即斐波那契数列
     *
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
