package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-26<p>
// 注释说明
// -------------------------------------------------------
public class LetterCasePermutation {
    public static final Set<String> dup = new HashSet<String>();

    public static void main(String[] args) {
        String a = "C";
        System.out.println(new LetterCasePermutation().letterCasePermutation(a));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> rst = new ArrayList<String>();
        if (s.length() == 0) {
            return rst;
        }
        dup.clear();
        List<String> r = backtrace(s, 0);
        if (!r.isEmpty()) {
            rst.addAll(r);
        }

        return rst;
    }

    public List<String> backtrace(String s, int idx) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(s);
        sb.replace(idx, idx + 1, String.valueOf(Character.toUpperCase(sb.charAt(idx))));
        String lowWalue = sb.toString();
        sb.replace(idx, idx + 1, String.valueOf(Character.toLowerCase(sb.charAt(idx))));
        String upWalue = sb.toString();
        if (!dup.contains(lowWalue)) {
            dup.add(lowWalue);
            result.add(lowWalue);
        }
        if (!dup.contains(upWalue)) {
            dup.add(upWalue);
            result.add(upWalue);
        }
        if (idx == s.length() - 1) {
            return result;
        } else {
            List<String> ot = backtrace(lowWalue, idx + 1);
            if (!ot.isEmpty()) {
                result.addAll(ot);
            }
            List<String> ot1 = backtrace(upWalue, idx + 1);
            if (!ot1.isEmpty()) {
                result.addAll(ot1);
            }
        }
        return result;
    }
}
