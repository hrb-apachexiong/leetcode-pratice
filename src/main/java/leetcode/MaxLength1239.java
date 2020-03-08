package leetcode;

import com.google.common.collect.Lists;

import java.util.*;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-07<p>
// 注释说明
// -------------------------------------------------------
public class MaxLength1239 {

    private static Map<String, Integer> cacheBit = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        System.out.println(3 & 15);


        List<String> params = new ArrayList<>();

//        params.addAll(Lists.newArrayList("jnfbyktlrqumowxd", "mvhgcpxnjzrdei"));
//        params.addAll(Lists.newArrayList("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po"));
        params.addAll(Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"));
//        params.addAll(Lists.newArrayList("ab", "cd"));

        System.out.println(new MaxLength1239().maxLength(params));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(cacheBit.size());
    }

    String result = "";

    public int maxLength(List<String> arr) {
        if (arr.size() == 1) {
            return arr.get(0).length();
        }

        // init.
        cacheBit.clear();
        for (String node : arr) {
            int bit = 0;
            for (char c : node.toCharArray()) {
                int b = 1 << (c - 'a');
                if ((b & bit) > 0) {
                    bit = 0;
                    break;
                } else {
                    bit = bit | b;
                }
            }
            cacheBit.put(node, bit);
        }

        backtrace("", 0, 0, arr, 0);
        return result.length();
    }

    void backtrace(String before, int bbit, int length, List<String> arr, int index) {
//        System.out.println(before + " " + index + " " + length);
        if (length > result.length()) {
            result = before;
        }
        if (index == arr.size()) {
            return;
        }

//        for (int i = index; i < arr.size(); i++) {
        String node = arr.get(index);
        //不加

        backtrace(before, bbit, length, arr, index + 1);

        //加入
        int nbit = cacheBit.get(node);
        if (nbit != 0 && (nbit & bbit) == 0) {
            backtrace(before + node, (nbit | bbit), length + node.length(), arr, index + 1);
        }

//        }
    }


}
