package leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-19<p>
// 注释说明
// -------------------------------------------------------
public class Partition131 {
    public static void main(String[] args) {
        System.out.println(new Partition131().partition("abba"));
    }

    public List<List<String>> partition(String s) {
        if (s.length() < 1) {
            return new ArrayList<>();
        }
        backtrace(new LinkedList<>(), s, 0);
        return result;
    }

    List<List<String>> result = new ArrayList<>();

    public void backtrace(LinkedList<String> tracer, String s, int idx) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(tracer));
        }

        //next回文串
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                tracer.add(s.substring(idx, i + 1));
                backtrace(tracer, s, i + 1);
                tracer.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        int size = (end - start + 1) / 2;
        for (int i = 0; i < size; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

}
