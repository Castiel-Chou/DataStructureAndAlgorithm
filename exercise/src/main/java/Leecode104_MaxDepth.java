import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: MaxDepth
 * @Description:
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/22 10:22
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }
}

public class Leecode104_MaxDepth {
    public static int maxDepth(TreeNode root) {
        // 当为空树时 直接返回
        if (root == null) return 0;
        // 不为空树时 创建一个队列用于保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将root节点入队
        queue.add(root);
        // 初始化总层数
        int level = 0;
        // 用来记录每一层有几个节点
        int eachLevelNode = 0;
        // 用于判断每一层是否是最后一个节点
        // 因为第一层只有一个root节点 所以初始值设置为1
        int preCount = 1;

        while (!queue.isEmpty()) {
            // 取出当前的这个节点
            TreeNode tmp = queue.poll();
            // 每层节点数-1
            preCount--;
            // 如果当前节点的左子节点有值
            if (tmp.left != null) {
                // 将该左子节点入队
                queue.add(tmp.left);
                // 该层节点数+1
                eachLevelNode ++;
            }
            // 右子树同理
            if (tmp.right != null) {
                queue.add(tmp.right);
                eachLevelNode ++;
            }
            // 只有当到达每一层的最后一个节点时
            if (preCount == 0) {
                // 将每层的节点个数给到preCount
                preCount = eachLevelNode;
                // 重置
                eachLevelNode = 0;
                // 层数+1
                level ++;
            }
        }
        return level;
    }
}
