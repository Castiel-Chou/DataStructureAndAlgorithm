/**
 * @ClassName: Leetcode2_AddTwoNumbers
 * @Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/15 15:15
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
}

public class Leetcode2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：根据链表节点的顺序 分别取出最后一位相加
        // 将结果存入一个新的链表中
        // 若为两位数 则按个位->十位的顺序存入新链表的节点

        // 创建一个新的链表 该节点为头结点
        ListNode node = new ListNode(0);
        // 创建一个链表的移动指针
        ListNode tmp = node;
        // 设定一个保存余数的数字
        int num = 0;
        // 遍历两条链表
        while (l1 != null || l2 != null || num != 0) {
            // 一次取出l1和l2的节点数字并相加
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + num;  // 将两个数字和余数相加
            int single = sum % 10;  // 取出相加后的个位数
            num = sum / 10;  // 取出相加后的十位数
            ListNode listNode = new ListNode(single);  // 将个位数放入链表中
            tmp.next = listNode;  // 将新增的节点加入链表最后
            tmp = tmp.next;  // 链表指针后移

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return node.next;
    }
}
