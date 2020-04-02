package leetcode.dp;

import com.google.gson.internal.$Gson$Preconditions;
import leetcode.backtrace.CoinChange322;

import java.util.Arrays;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-30<p>
// 注释说明
// -------------------------------------------------------
public class DpCoinChange322 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new DpCoinChange322().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 5 2 1
        // 11
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


}
