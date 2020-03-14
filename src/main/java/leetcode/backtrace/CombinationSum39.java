package leetcode.backtrace;


import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-09<p>
// 注释说明
// -------------------------------------------------------
public class CombinationSum39 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum39().combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        backtrace(candidates, new LinkedList<>(), 0, target, 0);
        return result;
    }

    public void backtrace(int[] candidates, LinkedList<Integer> trace, int sum, int target, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(trace));
        }

        for (int i=index; i<candidates.length; i++) {
            int cand = candidates[i];
            if (cand + sum > target) {
                continue;
            }
            trace.add(cand);
            backtrace(candidates, trace, sum+cand, target, i);
            trace.removeLast();
        }

    }
}
