package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-05<p>
// 注释说明
// -------------------------------------------------------

public class Anagram242 {

    public static void main(String[] args) {
        System.out.println(new Anagram242().isAnagram("rom","roc"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] code = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            code[c] = code[c] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i) - 'a';
            code[c] = code[c] - 1;
            if (code[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
