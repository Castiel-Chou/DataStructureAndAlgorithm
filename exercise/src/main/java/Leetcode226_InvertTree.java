import sun.reflect.generics.tree.Tree;

/**
 * @ClassName: Leetcode226_InvertTree
 * @Description:
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/19 10:59
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
class TreeNode226 {
    int val;
    TreeNode226 left;
    TreeNode226 right;
    public TreeNode226(int x) {val = x;}
}

public class Leetcode226_InvertTree {

    public TreeNode226 invertTree(TreeNode226 root) {
        if (root == null) return null;

        TreeNode226 left = invertTree(root.left);
        TreeNode226 right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

}
