package leetcode.backtrace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-20<p>
// 注释说明
// -------------------------------------------------------
public class CountArrangement526 {
    public static void main(String[] args) {
        System.out.println(new CountArrangement526().countArrangement(15));
    }

    public int countArrangement(int N) {
        for (int i = 1; i <= N; i++) {
            tracer.put(i, true);
        }

        backtrace(1, N);
        return resultCnt;
    }

    Map<Integer, Boolean> tracer = new HashMap<>();
    int resultCnt;

    public void backtrace(int idx, int end) {
        if (idx > end) {
            resultCnt++;
            return;
        }
        for (int i = 1; i <= end; i++) {
            if (tracer.get(i)
                    && (i % idx == 0 || idx % i == 0)) {
                tracer.put(i, false);
                backtrace(idx + 1, end);
                tracer.put(i, true);
            }
        }
    }


}
