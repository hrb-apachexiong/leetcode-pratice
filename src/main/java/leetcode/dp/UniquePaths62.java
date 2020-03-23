package leetcode.dp;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.w3c.dom.ls.LSOutput;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-21<p>
// 注释说明
// -------------------------------------------------------
public class UniquePaths62 {

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {

        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[i][0] = 1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }
        return result[n - 1][m - 1];
    }
}
