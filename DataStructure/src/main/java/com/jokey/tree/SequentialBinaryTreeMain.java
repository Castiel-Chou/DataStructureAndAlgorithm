package com.jokey.tree;

/**
 * @ClassName: SequentialBinaryTree
 * @Description: 顺序存储二叉树
 * 从数据存储来看，数组存储方式和树存储方式可以互相转换
 * 现在有一棵完全二叉树，每层的数据都是从小到大排列,如下所示
 *          1
 *       2    3
 *    4  5    6  7
 * 将其转为数组即为[1,2,3,4,5,6,7]
 *
 * 现在要求还是按照前中后序的树的遍历来输出数组
 * 前序(1-2-4-5-3-6-7)
 * 中序(4-2-5-1-6-3-7)
 * 后序(4-5-2-6-7-3-1)
 *
 * 顺序存储二叉树的特点：
 * 1.通常只考虑完全二叉树
 * 2.第n个元素的左子节点为 2n+1
 * 3.第n个元素的右子节点为 2n+2
 * 4.第n个元素的父节点为 (n-1)/2
 * 5.n表示元素在二叉树中的位置(从0开始)
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/8 13:50
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
class SequentialBinaryTree {
    private int[] arr;
    public SequentialBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int idx) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        // 和前序遍历类似 先输出当前元素
        System.out.println(arr[idx]);
        // 向左遍历
        int tmp = 2*idx + 1;
        if (tmp < arr.length) {
            preOrder(tmp);
        }
        // 向右遍历
        tmp = 2*idx + 2;
        if (tmp < arr.length) {
            preOrder(tmp);
        }
    }
}


public class SequentialBinaryTreeMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree(arr);
        sequentialBinaryTree.preOrder();
    }
}
