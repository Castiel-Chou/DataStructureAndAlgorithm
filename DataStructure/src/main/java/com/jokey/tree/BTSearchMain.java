package com.jokey.tree;

/**
 * @ClassName: BTSearch
 * @Description: 二叉树搜索
 * @Author: Jokey Zhou
 * @Date: 2020/4/7 11:48
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
class TreeSearchNode {
    public int id;
    public String name;
    public TreeSearchNode left;
    public TreeSearchNode right;

    public TreeSearchNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeSearchNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class BTSearch {
    private TreeSearchNode root;
    public BTSearch(TreeSearchNode root) {
        this.root = root;
    }

    // 前序遍历
    public TreeSearchNode preOrderSearch(int id) {
        if (this.root.id == id) {
            return root;
        } else if (root.left != null) {
            // 左子树搜寻
            return preOrderSearch(this.root.left.id);
        } else if (root.right != null) {
            // 右子树搜寻
            return preOrderSearch(this.root.right.id);
        } else {
            return null;
        }
    }

}

public class BTSearchMain {
    public static void main(String[] args) {
        TreeSearchNode node1 = new TreeSearchNode(1, "aaa");
        TreeSearchNode node2 = new TreeSearchNode(2, "bbb");
        TreeSearchNode node3 = new TreeSearchNode(3, "ccc");
        TreeSearchNode node4 = new TreeSearchNode(4, "ddd");
        TreeSearchNode node5 = new TreeSearchNode(5, "eee");
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        BTSearch btSearch = new BTSearch(node1);
        System.out.println(btSearch.preOrderSearch(4));
    }
}
