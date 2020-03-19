package leetcode.stack;

import java.util.LinkedList;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-14<p>
// 注释说明
// -------------------------------------------------------
public class Match10 {

    public static void main(String[] args) {
        System.out.println(new Match10().isMatch("bba", ".*b"));
    }

    public boolean isMatch(String s, String p) {
        boolean result = backtrace(s, p, 0, 0);
        return result;
    }

    public boolean backtrace(String s, String p, int sidx, int pidx) {
        System.out.println(sidx + ", " + pidx);
        if (sidx == s.length() && p.length() == pidx) {
            return true;
        }

        if (sidx > s.length() || p.length() == pidx) {
            return false;
        }

        //.和普通
        if (sidx == s.length()) {
            if (p.length() == (pidx + 1)) {
                if (p.charAt(pidx) == '*') {
                    return true;
                } else {
                    return false;
                }

            }
            if ((p.length() - pidx) % 2 == 1) {
                return false;
            }

            for (int i = pidx + 1; i < p.length(); i += 2) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (pidx == p.length() - 1
                || (pidx < p.length() - 1 && p.charAt(pidx + 1) != '*')) {
            if (p.charAt(pidx) == '.' || p.charAt(pidx) == s.charAt(sidx)) {
                boolean match = backtrace(s, p, sidx + 1, pidx + 1);
                if (match) {
                    return match;
                }
            }
            // *
        } else if (p.charAt(pidx) != '.') {
            boolean match = backtrace(s, p, sidx, pidx + 2);
            if (match) {
                return match;
            }

            if (s.charAt(sidx) == p.charAt(pidx)) {
                for (int i = sidx + 1; i <= s.length() && s.charAt(i - 1) == p.charAt(pidx); i++) {
                    match = backtrace(s, p, i, pidx + 2);
                    if (match) {
                        return match;
                    }
                }
            }
        } else {
            for (int i = sidx; i <= s.length(); i++) {
                boolean match = backtrace(s, p, i, pidx + 2);
                if (match) {
                    return match;
                }
            }
        }
        return false;
    }

}
