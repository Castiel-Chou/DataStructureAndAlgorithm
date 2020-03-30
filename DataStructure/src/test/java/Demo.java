/**
 * @author Jokey Zhou
 * @version 1.0
 * @date 2020/2/13 13:07
 * @description: TODO
 * 赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Demo {
    public static void main(String[] args) {
        add_month(202003,1);
        add_month(202003,13);
        add_month(202003,-2);
        add_month(202003,-3);
    }

    public static void add_month(int date, int num) {
        if (date <= 0 || date + num <=0 ) {
            System.out.println("输入的参数不合法");
            return;
        }

        String rawDate = date + "";
        String year = rawDate.substring(0, 4);  // 截取出年
        int year1 = Integer.parseInt(year);
        String month = rawDate.substring(4);  // 截取出月
        int month1 = Integer.parseInt(month);

        if (num >= 0) {
            // 当第二个参数为正数时 逢12进1
            for (int i=0; i< num; i++) {
                month1 ++;
                if (month1 > 12) {
                    year1 ++;
                    month1 = 1;
                }
            }
        } else {
            // 当第二个参数为负数时 逢0退1
            for (int i=0; i<Math.abs(num); i++) {
                month1 --;
                if (month1 == 0) {
                    year1 --;
                    month1 = 12;
                }
            }
        }

        // 将int型转为String类型
        if (month1 / 10 > 0) {
            month = month1 + "";
        } else {
            month = "0" + month1;
        }

        System.out.println(year1+month);
    }
}
