package com.jokey.math;

/**
 * @ClassName: GcdProblem
 * @Description: 求两个数的最大公约数
 * 采用辗转相除法
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/2 16:28
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class GcdProblem {
    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        System.out.println(gcd(a, b));

    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
