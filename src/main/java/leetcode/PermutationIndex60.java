package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-05<p>
// 注释说明
// -------------------------------------------------------
public class PermutationIndex60 {


    public static void main(String[] args) {
        System.out.println(new PermutationIndex60().getPermutation(4, 9));
    }

    String result = "";

    public String getPermutation(int n, int k) {

        AtomicInteger inc = new AtomicInteger();
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(track, n, k, inc);
        return result;
    }

    public void backtrace(LinkedList<Integer> track, int n, int k, AtomicInteger incr) {
        if (incr.get() == k) {
            return;
        }
        if (track.size() == n) {
            int cnt = incr.incrementAndGet();
            if (cnt == k) {
                StringBuilder sb = new StringBuilder();
                track.stream().forEach(cr -> {
                    sb.append(cr);
                });
                result = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            backtrace(track, n, k, incr);
            track.removeLast();
        }

    }

}
