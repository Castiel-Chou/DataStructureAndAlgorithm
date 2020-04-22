import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: Leetcode199_RightSideView
 * @Description:
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/22 17:30
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

class TreeNode199 {
    int val;
    TreeNode199 left;
    TreeNode199 right;
    public TreeNode199(int x) {
        this.val = x;
    }
}
public class Leetcode199_RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        // 思路还是层序遍历 将每层最后一个节点添加到arr中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int pCount = 0;
        int preCount = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            preCount --;

            if (tmp.left != null) {
                queue.add(tmp.left);
                pCount ++;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                pCount ++;
            }
            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                arr.add(tmp.val);
            }
        }
        return arr;
    }
}
