package com.jokey.tree;

/**
 * @ClassName: BinaryTree
 * @Description: 二叉树的前序遍历，中序遍历，后序遍历，删除(递归版本)
 * 给定一棵二叉树
 *      1
 *   2    3
 * 4  5
 *
 * 前序遍历：先输出父节点(root)，再遍历左子树，最后遍历右子树(1-2-3-5-3)
 * 中序遍历：先遍历左子树，再输出父节点，最后遍历右子树(4-2-5-1-3)
 * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点(4-5-2-3-1)
 * 所以可以看出，三种遍历的区别就在于父节点在哪个位置输出
 *
 *
 * 删除节点：
 * 如果是叶子节点就直接删除，如果是非叶子结点则直接删除子树
 * 1.因为二叉树是单向的，所以应该判断的是当前节点的子节点是否是需要删除的节点
 * 2.如果当前节点的左子节点不为空，并且该左子节点就是需要删除的节点，就将this.left=null,同时结束递归删除
 * 3.同理，根据上述思路进行当前节点右子节点的操作
 * 4.如果上面两步之后没有删除目标节点，则向左子树递归删除
 * 5.如果第4步还是没有删除节点，则向右递归删除
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/7 10:20
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */

class TreeNode {  // 定义一个二叉树的节点类
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    // 前序遍历
    public void preOrder() {
        // 先输出父节点
        System.out.println(this.val);
        // 遍历左子树
        if (left != null) left.preOrder();
        // 遍历右子树
        if (right != null) right.preOrder();
    }

    // 中序遍历
    public void inOrder() {
        // 先找左子树
        if (left != null) left.inOrder();
        // 输出父节点
        System.out.println(this.val);
        // 遍历右子树
        if (right != null) right.inOrder();
    }

    // 后序遍历
    public void postOrder() {
        // 先遍历左子树
        if (left != null) left.postOrder();
        // 再遍历右子树
        if (right != null) right.postOrder();
        // 最后输出父节点
        System.out.println(this.val);
    }

    // 删除节点
    public void delNode(int id) {
        // 如果当前节点的左子节点不为空，并且该左子节点就是需要删除的节点，结束递归
        if (this.left != null && this.left.val == id) {
            this.left = null;
            return;
        }
        // 如果当前节点的右子节点不为空，并且该右子节点就是需要删除的节点，结束递归
        if (this.right != null && this.right.val == id) {
            this.right = null;
            return;
        }
        // 上面两步都没找到 向左子树递归删除
        if (left != null) {
            left.delNode(id);
        }
        // 向左子树递归没找到 向右子树递归
        if (right != null) {
            right.delNode(id);
        }
    }
}

class BinaryTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (root != null) root.preOrder();
    }

    // 中序遍历
    public void inOrder() {
        if (root != null) root.inOrder();
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) root.postOrder();
    }

    // 删除节点
    public void delNode(int val) {
        // 首先看root节点是否为空
        if (root != null) {
            // root节点不为空 判断该节点是否是需要删除的节点
            if (root.val == val) {
                root = null;
            } else {
                // root不是需要删除的节点 则开始递归删除
                root.delNode(val);
            }
        } else {
            // 如果root节点为空
            System.out.println("二叉树为空");
        }
    }
}

public class BinaryTreeMain {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(treeNode1);
        binaryTree.preOrder();
        System.out.println("=====================");
        binaryTree.delNode(1);
        binaryTree.preOrder();
//        System.out.println("==========================");
//        binaryTree.inOrder();
//        System.out.println("==========================");
//        binaryTree.postOrder();
    }
}
