/**
 * @author Jokey Zhou
 * @version 1.0
 * @date 2020/2/13 13:07
 * @description: 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {3, 8, 6, 6, 5, 9};
        int distance = 10000;
        int count = 0;
        while (true) {
            if (distance <= 0) {
                break;
            }
            distance = distance - nums[count % 6];
            count ++;
        }

        System.out.println(count);
    }
}
