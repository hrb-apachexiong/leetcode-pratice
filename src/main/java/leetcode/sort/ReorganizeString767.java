package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-19<p>
// 注释说明
// -------------------------------------------------------
public class ReorganizeString767 {
    public static void main(String[] args) {
        System.out.println(new ReorganizeString767().reorganizeString("aaba"));
    }

    class MyChar {
        char ch;
        int count;
    }


    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < chars.length; i++) {
            cnt[chars[i] - 'a']++;
        }
        PriorityQueue<MyChar> dui = new PriorityQueue(s.length(), new Comparator<MyChar>() {
            @Override
            public int compare(MyChar o1, MyChar o2) {
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                MyChar myChar = new MyChar();
                myChar.ch = (char) ('a' + i);
                myChar.count = cnt[i];
                dui.add(myChar);
            }
        }


        //build it
        StringBuilder sb = new StringBuilder();
        while (dui.size() > 1) {
            MyChar top1 = dui.poll();
            MyChar top2 = dui.poll();

            sb.append(top1.ch).append(top2.ch);
            if (top1.count > 1) {
                top1.count--;
                dui.add(top1);
            }
            if (top2.count > 1) {
                top2.count--;
                dui.add(top2);
            }
        }
        if (dui.size() == 0) {
            return sb.toString();
        }
        MyChar last = dui.poll();
        if (last.count > 1 || last.ch == sb.charAt(sb.length() - 1)) {
            return "";
        }

        sb.append(last.ch);
        return sb.toString();
    }
}
