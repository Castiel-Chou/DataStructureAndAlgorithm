/**
 * @ClassName: Leetcode171_TitleToNumber
 * @Description:
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/23 14:00
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode171_TitleToNumber {
    public static int titleToNumber(String s) {
        // 这道题是26进制的一道题
        // 初始化最终结果
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // 得出每个位数上的数值
            int num = s.charAt(i) - 'A' + 1;
            // 26进制转化
            sum = sum * 26 + num;
        }
        return sum;
    }
}
