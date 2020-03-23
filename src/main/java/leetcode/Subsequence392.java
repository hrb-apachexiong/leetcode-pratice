package leetcode;

import leetcode.stack.Subsets78;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-22<p>
// 注释说明
// -------------------------------------------------------
public class Subsequence392 {
    public static void main(String[] args) {
        System.out.println(new Subsequence392().isSubsequence("ab", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;

        for (; i < t.length() && j < s.length(); ) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == s.length();
    }
}
