package com.jokey.tree;

/**
 * @ClassName: BinaryTree
 * @Description: 二叉树的前序遍历，中序遍历，后序遍历
 * 给定一棵二叉树
 *      1
 *   2    3
 * 4  5
 *
 * 前序遍历：先输出父节点(root)，再遍历左子树，最后遍历右子树
 * 中序遍历：先遍历左子树，再输出父节点，最后遍历右子树
 * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 * 所以可以看出，三种遍历的区别就在于父节点在哪个位置输出
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
}

class BinaryTree {
    public TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    // 后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
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

        BinaryTree binaryTree = new BinaryTree(treeNode1);
        binaryTree.preOrderTraversal(treeNode1);
        System.out.println("================================================");
        binaryTree.inOrderTraversal(treeNode1);
        System.out.println("================================================");
        binaryTree.postOrderTraversal(treeNode1);
    }
}
