package leetcode.backtrace;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-23<p>
// 注释说明
// -------------------------------------------------------
public class WaysToChange0811 {

    public static void main(String[] args) {
        System.out.println(new WaysToChange0811().waysToChange(107500));
    }
    public int waysToChange(int n) {
        int max25 = n / 25;
        int max10 = n / 10;
        int max5 = n / 5;
        int result = 0;
        for (int m25 = 0; m25 <= max25; m25++) {
            int sum25 = 25 * m25;
            for (int m10 = 0; m10 <= max10 && sum25 + 10 * m10 <= n; m10++) {
                int sum10 = 10 * m10;
                for (int m5 = 0; m5 <= max5 && sum25 + sum10 + 5 * m5 <= n; m5++) {
                    result++;
                }
            }
        }
        return result;
    }
}
