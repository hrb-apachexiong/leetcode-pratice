package leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-08<p>
// 注释说明
// -------------------------------------------------------
public class MaxLength1239DP {
    class MyStr {
        // 定义 可行解的数据结构 包括值和字符串
        int size;
        int num;

        MyStr(int num, int size) {
            this.num = num;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> params = new ArrayList<>();
        params.addAll(Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"));
        System.out.println(new MaxLength1239DP().maxLength(params));
        System.out.println(System.currentTimeMillis() - start);

    }

    public int maxLength(List<String> arr) {
        List<MyStr> myStrs = new ArrayList<>();
        for (String str : arr) {
            int value = str2int(str);
            if (value != -1)
                myStrs.add(new MyStr(value, str.length()));
        }
        int max = 0;
        List<MyStr> answers = new ArrayList<>();
        for (int i = 0; i < myStrs.size(); i++) {
            List<MyStr> plus = new ArrayList<>();
            MyStr cur = myStrs.get(i);
            plus.add(cur);
            max = Math.max(max, cur.size);
            for (int j = 0; j < answers.size(); j++) {
                MyStr pre = answers.get(j);
                if ((cur.num & pre.num) == 0) {
                    int size = cur.size + pre.size;
                    max = Math.max(max, size);
                    plus.add(new MyStr((cur.num | pre.num), size));
                }
            }
            answers.addAll(plus);
        }
        System.out.println(answers.size());
        return max;
    }

    // 如果字符串内部有重复 return -1
    private int str2int(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            if (getBit(num, k)) return -1;
            num = setBit(num, k);
        }
        return num;
    }

    private boolean getBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }

    private int setBit(int num, int k) {
        return num | (1 << k);
    }
}
