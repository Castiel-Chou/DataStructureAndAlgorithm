/**
 * @ClassName: Leetcode206_reverseList
 * @Description:
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/22 16:56
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

class ListNode206 {
    int val;
    ListNode206 next;
    ListNode206(int x) {this.val = x;}
}

public class Leetcode206_reverseList {

    public static ListNode206 reverseList(ListNode206 head) {
        // 定义前置指针
        ListNode206 pre = null;
        // 初始化next指针
        ListNode206 next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
