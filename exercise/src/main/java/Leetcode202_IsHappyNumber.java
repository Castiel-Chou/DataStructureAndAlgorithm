import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Leetcode202_IsHappyNumber
 * @Description:
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *  
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/7 11:24
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode202_IsHappyNumber {

    // 这道题如果不是快乐数 那么最终会形成一个不断循环的结果
    // 因此可以将每次的结果放入HashSet中
    // 以此来判断若在HashSet中 则表示该数不是快乐数

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 开始做循环
        while (true) {
            // 先将n的各个位上的数的平方相加
            n = addNumber(n);
            // 当set中有这个数了 表示进入了循环 不是快乐数
            if (set.contains(n)) {
                return false;
            } else {
                // 如果没有收敛到1 将该数加入set
                if (n != 1) {
                    set.add(n);
                } else {
                    // 如果收敛到1 表示该数为快乐数
                    return true;
                }
            }
        }
    }

    /**
     * 将输入的数字各个位上的数的平方相加
     * @param num
     * @return 各位数字平方和
     */
    public static int addNumber(int num) {
        int sum = 0;
        while (num > 0) {
            int i = num % 10;
            sum += Math.pow(i, 2);
            num /= 10;
        }
        return sum;
    }
}
