package com.jokey.sparsearray;

/**
 * @author Jokey Zhou
 * @version 1.0
 * @date 2020/2/12 13:16
 * @description: 稀疏数组和原始二维数组的相互转换
 * @Good morning, and in case I don't see you, good afternoon, good evening, and good night!
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 假设我们原始二维数组在第二行第三列有黑子、第三行第四列有蓝子
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] originalArr = new int[11][11];
        originalArr[1][2] = 1;
        originalArr[2][3] = 2;

        // 输出原始的二维数组
        for (int[] i : originalArr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组的思路
        // 1. 先遍历二维数组 得到非0数据的个数
        int count = 0;
        for (int[] i : originalArr) {
            for (int j : i) {
                if (j != 0) {
                    count += 1;
                }
            }
        }
        System.out.println("========================================");
        System.out.println(count);

        // 2. 创建对应的稀疏数组
        int[][] sparseArr = new int[count+1][3];

        // 2.1 给稀疏数组的第一行赋初始值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int num = 1;
        for (int i=0; i<originalArr.length; i++) {
            for (int j=0; j<originalArr[0].length; j++) {  // 此处originalArr[0].length就是二维数组的列数
                if (originalArr[i][j] != 0) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = originalArr[i][j];
                    num += 1;
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println("========================================");
        for (int[] i : sparseArr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }


        // 将稀疏数组 --> 恢复成 原始的二维数组
		/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] twoDimensionalArr = new int[row][col];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i=1; i<sparseArr.length; i++) {
            twoDimensionalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("========================================");
        for (int[] i : twoDimensionalArr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }


    }
}
