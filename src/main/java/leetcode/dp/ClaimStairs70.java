package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-08<p>
// 注释说明
// -------------------------------------------------------
public class ClaimStairs70 {

    //典型的，可以分解成子问题
    //n阶梯， 可由 f(n) = f(n-1) + f(n-2)
    //边界 f(1) = 1 f(2) = 2
    public int climbStairs(int n) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(1, 1);
        resultMap.put(2, 2);

        for (int i = 3; i <= n; i++) {
            resultMap.put(i, resultMap.get(i - 2) + resultMap.get(i - 1));
        }

        return resultMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new ClaimStairs70().climbStairs(10));
    }
}
