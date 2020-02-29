package leetcode;

import java.util.ArrayList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-28<p>
// 注释说明
// -------------------------------------------------------
public class NQueue {

    public static void main(String[] args) {
        List<List<String>> r = new NQueue().solveNQueens(5);

        for (List<String> sl : r) {
            for (String s : sl) {
                System.out.println(s);
            }
            System.out.println("###########");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] table = new int[n][n];

        List<int[][]> result = solve(table, 0, 0, n);

        List<List<String>> rs = new ArrayList<List<String>>();
        for (int[][] ar : result) {
            List<String> ta = new ArrayList<String>(n);
            for (int i = 0; i < ar.length; i++) {
                String line = "";
                for (int j = 0; j < ar[i].length; j++) {
                    if (ar[i][j] == 0) {
                        line += ".";
                    } else {
                        line += "Q";
                    }
                }
                ta.add(line);
            }
            rs.add(ta);
        }
        return rs;
    }

    public List<int[][]> solve(int[][] tab, int i, int j, int queue) {
        List<int[][]> result = new ArrayList<int[][]>();
        if (queue <= 0) {
            result.add(tab);
            return result;
        }
        int startJ = j;
        for (int si = i; si < tab.length; si++) {
            for (int sj = startJ; sj < tab[si].length; sj++) {
                startJ = 0;
                if (isOk(tab, si, sj)) {
                    int[][] element = copy(tab);
                    element[si][sj] = 1;
                    List<int[][]> subResult = solve(element, si + 1, 0, queue - 1);
                    if (subResult.size() > 0) {
                        result.addAll(subResult);
                    }
                    subResult = solve(tab, si, sj + 1, queue);
                    if (subResult.size() > 0) {
                        result.addAll(subResult);
                    }
                    return result;
                }
            }
        }
        return result;
    }

    public int[][] copy(int[][] from) {
        int[][] result = new int[from.length][from.length];
        for (int i = 0; i < from.length; i++) {
            System.arraycopy(from[i], 0, result[i], 0, from[i].length);
        }
        return result;
    }

    private boolean isOk(int[][] tab, int i, int j) {
        //check 横
        for (int hj = 0; hj < tab[i].length; hj++) {
            if (hj == j) {
                continue;
            }
            if (tab[i][hj] == 1) {
                return false;
            }
        }
        //check 横
        for (int hi = 0; hi < tab.length; hi++) {
            if (hi == i) {
                continue;
            }
            if (tab[hi][j] == 1) {
                return false;
            }
        }

        //check 正斜杠
        int startI = 0;
        int startJ = 0;
        if (i < j) {
            startI = 0;
            startJ = j - i;
        } else {
            startI = i - j;
            startJ = 0;
        }

        for (int inc = 0; startI + inc < tab.length && startJ + inc < tab[i].length; inc++) {
            if (startI + inc == i && startJ + inc == j) {
                continue;
            }
            if (tab[startI + inc][startJ + inc] == 1) {
                return false;
            }
        }
        //check反写
        startI = i + j;
        startJ = 0;
        if (startI > tab.length - 1) {
            startI = tab.length - 1;
            startJ = j - (startI - i);
        }

        for (int inc = 0; startJ + inc < tab[i].length && startI - inc < tab.length && startI - inc >= 0; inc++) {
            if (startI - inc == i || startJ + inc == j) {
                continue;
            }
            if (tab[startI - inc][startJ + inc] == 1) {
                return false;
            }
        }
        return true;
    }
}
