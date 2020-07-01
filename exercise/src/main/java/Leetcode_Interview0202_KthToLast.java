/**
 * @ClassName: Leetcode_Interview0202_KthToLast
 * @Description:
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/7/1 15:26
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode_Interview0202_KthToLast {

    public static int kthToLast(ListNode head, int k) {
        // 设置一个辅助指针节点
        ListNode tmp = head;
        // 初始化链表有效节点个数
        int capacity = 0;
        while (tmp != null) {
            capacity ++;
            tmp = tmp.next;
        }


        int target = capacity - k + 1;
        int value = 0;
        int i = 1;
        ListNode tmp2 = head;
        while (i <= target) {
            value = tmp2.val;
            tmp2 = tmp2.next;
            i ++;
        }

        return value;
    }
}
