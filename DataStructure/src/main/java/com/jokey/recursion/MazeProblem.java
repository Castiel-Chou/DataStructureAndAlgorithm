package com.jokey.recursion;

/**
 * @ClassName: MazeProblem
 * @Description: 用递归的思想解决迷宫问题
 * 有一个8 * 7的迷宫 用二维矩阵表示(1代表墙，0代表路)
 * 有一个小球从(1,1)出发 求小球到终点经过的路线
 *
 * @Author: Jokey Zhou
 * @Date: 2020/3/30 14:16
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class MazeProblem {
    public static void main(String[] args) {
        // 创建一个二维数组作为迷宫
        int[][] maze = new int[8][7];
        // 迷宫的边缘都是墙
        // 将第一行和最后一行全部置为1
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        // 将左右两列置为1
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        // 设置挡板
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[3][3] = 1;
        maze[3][4] = 1;

        findWay(maze, 1, 1);

        // 打印迷宫
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归的思路来处理小球迷宫找路问题
     *
     * 约定：
     * 当maze[i][j]为0时，表示这个点没有走过
     * 为1表示这个点是一堵墙，不能走
     * 为2表示这个点可以走通
     * 为3表示这个点走过但不能走通
     * 如果小球能走到maze[6][5]，就表示到达了终点
     *
     * 需要明确小球行走的路径，此处可定义为: 上 -> 右 -> 下 -> 左
     *
     * @param maze  原始的迷宫
     * @param i     从第i行开始找
     * @param j     从第j列开始找
     *              (i, j)即为小球的初始位置
     * @return      是否找到出路
     */
    public static boolean findWay(int[][] maze, int i, int j) {
        // 递归首先要确定出口
        if (maze[6][5] == 2) {
            return true;
        } else {  // 接下来开始找路
            // 1.假设这个点没有走过
            if (maze[i][j] == 0) {
                // 2.假设这条路可以走通，先把这个点设置为2
                maze[i][j] = 2;
                // 3.开始按照设定的顺序开始找路
                // 向上走
                if (findWay(maze, i-1, j)) return true;
                // 向右走
                else if (findWay(maze, i, j+1)) return true;
                // 向下走
                else if (findWay(maze, i+1, j)) return true;
                // 向左走
                else if (findWay(maze, i, j-1)) return true;
                // 当路走不通的时候 把这个点置为3
                else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                // 如果这个点不是0，可能是1/2/3
                return false;
            }
        }
    }
}
