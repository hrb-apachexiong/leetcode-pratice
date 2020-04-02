package leetcode.dp;

import sun.jvm.hotspot.utilities.soql.JSJavaVM;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-25<p>
// 注释说明
// -------------------------------------------------------
public class NumTree96 {
    public static void main(String[] args) {
        System.out.println(new NumTree96().numTrees(5));
    }

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int cnt = 0;
            for(int s = i; s>=1; s--){
                cnt += dp[s-1] * dp[i-s];
            }
            dp[i] = cnt;
        }
        return dp[n];
    }
}
