package leetcode;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-04<p>
// 注释说明
// -------------------------------------------------------
public class Parentbesis0809 {

    private static List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace(new LinkedList<>(), 0, 0, n);
        return result;
    }

    public void backtrace(LinkedList<Integer> track, int size0, int size1, int n) {
        if (track.size() == n * 2) {
            addResult(track);
            return;
        }

        //0
        if (size0 < n) {
            track.add(0);
            backtrace(track, size0 + 1, size1, n);
            track.removeLast();
        }

        //1
        if (size1 + 1 <= size0) {
            track.add(1);
            backtrace(track, size0, size1 + 1, n);
            track.removeLast();
        }
    }

    private void addResult(List<Integer> track) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : track) {
            if (0 == integer) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        result.add(sb.toString());

    }

    public static void main(String[] args) {
        System.out.println(new Parentbesis0809().generateParenthesis(1));

    }


}
