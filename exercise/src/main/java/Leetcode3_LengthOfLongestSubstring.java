import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Leetcode3_LengthOfLongestSubstring
 * @Description:
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/6/4 11:45
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode3_LengthOfLongestSubstring {
    /**
     * 思路：滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;  // 初始化滑动窗口的左指针
        int max = 0;  // 初始化最大窗口的长度

        // Hash表，key是字母，value是字母的下标
        Map<Character, Integer> map = new HashMap<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果字符串中已经出现过了这个字母
            if (map.containsKey(s.charAt(i))) {
                // 此时需要移动窗口左指针的位置
                // 正常情况是找到之前这个字母的下标，将左指针在此坐标上右移一位 但是考虑下面这种情况
                // "abba" 如果这时只是单纯的将左指针右移一位，那到最后的a左指针会往回走
                // 所以需要判断如果下标比左指针小，就不要移动指针了
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            // 将字母和对应的下标存入map
            map.put(s.charAt(i), i);
            // 最后需要比较的是当前的 右指针-左指针+1的大小和历史最大窗口大小
            // 选择两者中的较大者，即为无重复最大子串
            max = Math.max(i - left + 1, max);
        }
        return max;

    }

}
