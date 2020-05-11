/**
 * @ClassName: Leetcode242_IsAnagram
 * @Description:
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/11 11:42
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode242_IsAnagram {

    public static boolean isAnagram(String s, String t) {
        // 如果长度不同 直接返回false
        if (s.length() != t.length()) return false;

        // 因为题干中给出只考虑小写字母，所以创建26个字母空间数组
        int[] letterList = new int[26];
        for (int i=0; i<s.length(); i++) {
            letterList[s.charAt(i) - 'a'] ++;
            letterList[t.charAt(i) - 'a'] --;
        }

        // 如果是字母异位词，那么数组中所有的值都为0
        for (int n : letterList) {
            if (n != 0) return false;
        }
        return true;
    }
}
