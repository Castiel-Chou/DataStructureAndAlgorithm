/**
 * @ClassName: HanoiTower
 * @Description: 汉诺塔问题
 * 分治算法的经典案例
 *
 * @Author: Jokey Zhou
 * @Date: 2020/4/13 16:43
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower.hanoiTower(56, 'A', 'B', 'C');
    }

    public static void hanoiTower(int n, char a, char b, char c) {
        // 当只有一层时
        if (n == 1) {
            System.out.println(a + " -> " + c);
        } else {
            // 当有2层以上时
            // 先将a上的最后一层上面的最为一个整体，挪动到b
            // 再将a的最后一层挪动到c
            // 最后将b再挪动到c
            // 不管有多少层 都是按照这个思路来处理

            // 1.将a除最后一层外的挪动到b，挪动过程中用到了c
            hanoiTower(n-1, a, c, b);
            // 2.将a的最后一层挪动到c
            System.out.println(a + " -> " + c);
            // 3.将b上的挪动到c
            hanoiTower(n-1, b, a, c);
        }
    }
}
