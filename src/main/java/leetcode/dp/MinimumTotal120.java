package leetcode.dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-22<p>
// 注释说明
// 具体最优子结构
// f(i,pos) = min(v(i,pos) + f(i-1, pos-1 or pos+1))
//
///
// -------------------------------------------------------
public class MinimumTotal120 {

    public static void main(String[] args) {
        List<List<Integer>> params = new ArrayList<>();
        params.add(Lists.newArrayList(2));
        params.add(Lists.newArrayList(3, 4));
        params.add(Lists.newArrayList(6, 5, 7));
        params.add(Lists.newArrayList(4, 1, 8, 3));

        System.out.println(new MinimumTotal120().minimumTotal(params));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        Map<String, Integer> dpMap = new HashMap<>();
        dpMap.put("0-0", triangle.get(0).get(0));

        int result = Integer.MAX_VALUE;

        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> rowValue = triangle.get(row);
            for (int loc = 0; loc < rowValue.size(); loc++) {
                int minValue = 0;
                if (loc == 0) {
                    minValue = rowValue.get(loc) + dpMap.get((row - 1) + "-" + loc);
                } else if (loc == rowValue.size() - 1) {
                    minValue = rowValue.get(loc) + dpMap.get((row - 1) + "-" + (loc - 1));
                } else {
                    minValue = rowValue.get(loc) + Math.min(dpMap.get((row - 1) + "-" + loc), dpMap.get((row - 1) + "-" + (loc - 1)));
                }
                dpMap.put(row + "-" + loc, minValue);

                if (row == triangle.size() - 1) {
                    if (minValue < result) {
                        result = minValue;
                    }
                }
            }
        }
        return result;
    }


}
