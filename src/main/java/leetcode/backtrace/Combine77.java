package leetcode.backtrace;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-13<p>
// 注释说明
// -------------------------------------------------------
public class Combine77 {
    public static void main(String[] args) {
        System.out.println(new Combine77().combine(4, 2));
    }


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n < 1) {
            return result;
        }
        backtrace(new LinkedList<>(), n, k, 1);
        return result;
    }

    public void backtrace(LinkedList<Integer> trace, int n, int k, int index) {
        if (trace.size() == k) {
            result.add(new ArrayList<Integer>(trace));
            return;
        }
        if (index > n) {
            return;
        }

        backtrace(trace, n, k, index + 1);
        if (!trace.contains(index)) {
            trace.add(index);
            backtrace(trace, n, k, index + 1);
            trace.removeLast();
        }
    }

}
