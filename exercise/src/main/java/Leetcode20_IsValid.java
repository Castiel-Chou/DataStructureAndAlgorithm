import java.util.Stack;

/**
 * @ClassName: Leetcode20_IsValid
 * @Description:
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/28 14:15
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode20_IsValid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            // 这时输入的肯定是右半侧的括号
            // 1. 如果之前没有左半边的括号输入 那么此时直接输入右半边的括号 肯定是匹配不上的
            // 2. 如果之前有左半边括号输入 但是和现在这个右半边括号不匹配 也是无法匹配的
            else if (stack.isEmpty() || stack.pop() != ch) return false;
        }
        // 最后需要判断：如果都能配对 栈中是没有元素的
        return stack.isEmpty();
    }

}
