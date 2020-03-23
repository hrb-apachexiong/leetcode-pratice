package leetcode.backtrace;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-21<p>
// 注释说明
// -------------------------------------------------------
public class SplitIntoFibonacci842 {

    public static void main(String[] args) {
        System.out.println(new SplitIntoFibonacci842().splitIntoFibonacci("5511816597"));
    }


    public List<Integer> splitIntoFibonacci(String s) {
        backtrace(new LinkedList<>(), s, 0, 1);

        return result.isEmpty() ? new ArrayList<>() : result.get(0);
    }

    List<List<Integer>> result = new ArrayList<>();
    boolean flag = false;

    public void backtrace(LinkedList<Integer> tracer, String s, int idx, int min) {
        if (flag) {
            return;
        }

        if (idx == s.length()) {
            if (tracer.size() > 2) {
                flag = true;
                result.add(new ArrayList<>(tracer));
            }
            return;
        }

        for (int i = idx + min; i <= s.length(); i++) {
            int thisValue = fitFibonacci(s, tracer, idx, i, min);
            if (thisValue == -1) {
                continue;
            }
            if(tracer.size()>2) {
                min = Math.max(min, i - idx);
            }
            tracer.add(thisValue);
            backtrace(tracer, s, i, min);
            tracer.removeLast();
        }
    }

    private Integer fitFibonacci(String s, LinkedList<Integer> tracer, int start, int end, int min) {
        if (end - start > 1 && s.charAt(start) == '0') {
            return -1;
        }
        if(end - start > 10){
            return -1;
        }
        long thisValueLong = Long.parseLong(s.substring(start, end));
        if(thisValueLong > Integer.MAX_VALUE){
            return -1;
        }

        int thisValue = (int)thisValueLong;
        if (tracer.size() < 2) {
            return thisValue;
        }
        int lastOne = tracer.removeLast();
        int lastTwo = tracer.removeLast();
        boolean result = (lastOne + lastTwo) == thisValue;
        tracer.add(lastTwo);
        tracer.add(lastOne);
        if (!result) {
            return -1;
        } else {
            return thisValue;
        }
    }
}
