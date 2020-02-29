package leetcode;

import java.util.HashSet;
import java.util.Set;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-23<p>
// 注释说明
// -------------------------------------------------------
public class SearchWord79 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    Set<String> keySet = new HashSet<String>();
                    keySet.add(i + "@" + j);
                    boolean exist = exist(board, i, j, word, 0, keySet);
                    if (exist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int iPos, int jPos, String word, int wordPos, Set<String> keySet) {
        //上
        String key = (iPos - 1) + "@" + jPos;
        if (!keySet.contains(key) && iPos > 0 && board[iPos - 1][jPos] == word.charAt(wordPos + 1)) {
            if (wordPos + 1 == word.length() - 1) {
                return true;
            } else {
                keySet.add(key);
                boolean exist = exist(board, iPos - 1, jPos, word, wordPos + 1, keySet);
                if (exist) {
                    return exist;
                }
                keySet.remove(key);
            }
        }

        //下
        key = (iPos + 1) + "@" + jPos;
        if (!keySet.contains(key) && iPos < board.length - 1 && board[iPos + 1][jPos] == word.charAt(wordPos + 1)) {
            if (wordPos + 1 == word.length() - 1) {
                return true;
            } else {
                keySet.add(key);
                boolean exist = exist(board, iPos + 1, jPos, word, wordPos + 1, keySet);
                if (exist) {
                    return exist;
                }
                keySet.remove(key);
            }
        }

        //左
        key = iPos + "@" + (jPos - 1);
        if (!keySet.contains(key) && jPos > 0 && board[iPos][jPos - 1] == word.charAt(wordPos + 1)) {
            if (wordPos + 1 == word.length() - 1) {
                return true;
            } else {
                keySet.add(key);
                boolean exist = exist(board, iPos, jPos - 1, word, wordPos + 1, keySet);
                if (exist) {
                    return exist;
                }
                keySet.remove(key);
            }
        }

        //右
        key = iPos + "@" + (jPos + 1);
        if (!keySet.contains(key) && jPos < board[iPos].length - 1 && board[iPos][jPos + 1] == word.charAt(wordPos + 1)) {
            if (wordPos + 1 == word.length() - 1) {
                return true;
            } else {
                keySet.add(key);
                boolean exist = exist(board, iPos, jPos + 1, word, wordPos + 1, keySet);
                if (exist) {
                    return exist;
                }
                keySet.remove(key);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SEECS";
        System.out.println(new SearchWord79().exist(board, word));
    }
}
