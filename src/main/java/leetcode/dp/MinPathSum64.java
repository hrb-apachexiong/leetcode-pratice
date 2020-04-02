package leetcode.dp;

import com.sun.xml.internal.rngom.digested.DGrammarPattern;
import com.sun.xml.internal.rngom.digested.DGroupPattern;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-26<p>
// 注释说明
// -------------------------------------------------------
public class MinPathSum64 {
    public static void main(String[] args) {
        System.out.println(new MinPathSum64().minPathSum(new int[][]{{1, 3, 1},{1, 5, 1},{4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                    }
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
