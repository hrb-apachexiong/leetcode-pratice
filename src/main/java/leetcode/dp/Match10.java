package leetcode.dp;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-14<p>
// DP
// -------------------------------------------------------
public class Match10 {

    public static void main(String[] args) {
        System.out.println(new Match10().isMatch("aaa", ".*"));
    }

    /**
     * f(s,p) = f(s-1, p-1)
     * && ((s==p)
     * || p==.
     * || (p==* && (
     *          (f(s-1, p-1) && s == s-1)
     *        || f(s,p-2)
     *          ))
     *
     *
     * @param s
     * @param p
     * @return
     */

    int[][] dp = null;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        //init i
        dp[0][0] = 1;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                if (dp[0][i - 2] == 1) {
                    dp[0][i] = 1;
                }
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (dp[i - 1][j - 1] == 1
                            && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = 1;
                    }
                } else {
                    //*
                    if (p.charAt(j-2) == '.' &&  (dp[i-1][j] == 1 || dp[i-1][j-1] == 1)) {
                        dp[i][j] = 1;
                    } else if (dp[i][j - 2] == 1) {
                        dp[i][j] = 1;
                    } else if (dp[i][j - 1] == 1) {
                        dp[i][j] = 1;
                    } else if (i >= 2 && dp[i - 1][j - 1] == 1 && s.charAt(i - 1) == s.charAt(i - 2)) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        return dp[s.length()][p.length()] == 1;
    }


}
