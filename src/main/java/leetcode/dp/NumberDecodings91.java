package leetcode.dp;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-28<p>
// 注释说明
// -------------------------------------------------------
public class NumberDecodings91 {
    public static void main(String[] args) {
        System.out.println(new NumberDecodings91().numDecodings("12143"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.startsWith("0")) {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int dn = dp[i - 1];
            int before = s.charAt(i - 2) - '0';
            int now = s.charAt(i - 1) - '0';
            int sum = before * 10 + now;

            if (sum == 10 || sum == 20) {
                dn = 0 + dp[i - 2];//绑定后，和i-2组合
            } else if (sum > 10 && sum < 27) {
                dn = dp[i - 1] + dp[i - 2]; //增加了一种可能，及时i和i-1组合 然后在和 i-2排列。
            } else if (now == 0 && (before == 0 || before > 2)) {
                return 0;
            }
            dp[i] = dn;
        }
        return dp[s.length()];
    }
}
