package com.jokey.tree;

/**
 * @ClassName: BTSearch
 * @Description: 二叉树搜索
 * @Author: Jokey Zhou
 * @Date: 2020/4/7 11:48
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
class TreeSearchNode {  // 设置节点类
    // 为了后续方便赋值 此处不设置成类私有的属性
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

    // 前序遍历查找
    public TreeSearchNode preOrderSearch(int id) {
        // 定义一个辅助节点用于遍历
        TreeSearchNode tmp = null;
        // 先比较父节点的值和需要查找的值是否一致
        if (this.id == id) return this;
        else {
            // 遍历左子树
            if (left != null) {  // 当父节点的左子树不为空时
                tmp = left.preOrderSearch(id);  // 此时有可能找到，也可能没找到
            }
            // 当在左子树找到了，直接返回
            if (tmp != null) return tmp;
            // 左子树没找到 就在右子树寻找
            if (right != null) {
                tmp = right.preOrderSearch(id);
            }
        }
        // 到此处无论找到与否 都需要返回tmp值了
        // 只有两种情况：1、找到节点并返回节点信息 2、没找到节点返回null
        return tmp;
    }

    // 中序遍历查找
    public TreeSearchNode inOrderSearch(int id) {
        // 创建一个临时节点用于遍历
        TreeSearchNode tmp = null;
        // 中序遍历查找先找左子树
        if (left != null) {
            tmp = left.inOrderSearch(id);
        }
        if (tmp != null) return tmp;  // 若在左子树找到了 直接返回
        // 左子树没有找到 则比较父节点
        if (this.id == id) return this;
        // 遍历右子树
        if (right != null) {
            tmp = right.inOrderSearch(id);
        }
        // 不管是否找到 都进行返回
        return tmp;
    }

    // 后序遍历查找
    public TreeSearchNode postOrderSearch(int id) {
        // 老朋友了 依旧是创建一个辅助节点
        TreeSearchNode tmp = null;
        // 后序遍历查找先找左子树
        if (left != null) {
            tmp = left.postOrderSearch(id);
        }
        if (tmp != null) return tmp;
        // 若左子树没有找到 遍历右子树
        if (right != null) {
            tmp = right.postOrderSearch(id);
        }
        if (tmp != null) return tmp;
        // 最后查找父节点
        if (this.id == id) return this;
        // 都没找到 直接返回null
        return null;
    }


}

class BTSearch {
    // 设置根节点
    private TreeSearchNode root;

    public void setRoot(TreeSearchNode root) {
        this.root = root;
    }

    // 前序遍历查找
    public TreeSearchNode preOrderSearch(int id) {
        return root.preOrderSearch(id);
    }

    // 中序遍历查找
    public TreeSearchNode inOrderSearch(int id) {
        return root.inOrderSearch(id);
    }

    // 后序遍历查找
    public TreeSearchNode postOrderSearch(int id) {
        return root.postOrderSearch(id);
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

        BTSearch btSearch = new BTSearch();
        btSearch.setRoot(node1);
//        System.out.println(btSearch.preOrderSearch(1));
//        System.out.println(btSearch.preOrderSearch(7));
//        System.out.println(btSearch.inOrderSearch(2));
//        System.out.println(btSearch.inOrderSearch(9));
        System.out.println(btSearch.postOrderSearch(3));
        System.out.println(btSearch.postOrderSearch(0));

    }
}
