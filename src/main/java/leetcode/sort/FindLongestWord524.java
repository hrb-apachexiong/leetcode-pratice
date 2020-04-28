package leetcode.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-14<p>
// 注释说明
// -------------------------------------------------------
public class FindLongestWord524 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String res = new FindLongestWord524().findLongestWord("abpcplea", Lists.newArrayList("ale", "apple", "monkey", "plea"));
        System.out.println(res + " " + (System.currentTimeMillis() - start));

    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                if (j == str.length()) {
                    if (result.length() < str.length()
                            || (result.length() == str.length() && str.compareTo(result) > 0)) {
                        result = str;
                    }
                }
            }
        }
        return result;
    }

}
