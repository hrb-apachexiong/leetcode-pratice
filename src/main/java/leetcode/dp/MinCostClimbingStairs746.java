package leetcode.dp;

import com.google.gson.internal.bind.util.ISO8601Utils;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-23<p>
// 注释说明
// -------------------------------------------------------
public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    //    [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return 0;
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
