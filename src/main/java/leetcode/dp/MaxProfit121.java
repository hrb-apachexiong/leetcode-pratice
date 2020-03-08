package leetcode.dp;

import leetcode.MaxLength1239DP;

import java.util.HashMap;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-08<p>
// 注释说明
// -------------------------------------------------------
public class MaxProfit121 {


    //f(n) = max(f(n-1), n-1, n-2, n-3,,,,n-n-1);
    //fn(1) = 0, fn(2) = max(0, 2-1) fn(3) = max(f(n-1), 3-1, 3-2)
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(0, 0);
        for (int i = 1; i < prices.length; i++) {
            int nodeMax = resultMap.get(i-1);
            for (int j = 0; j < i; j++) {
                nodeMax = Math.max(prices[i] - prices[j], nodeMax);
            }
            resultMap.put(i, nodeMax);
        }
        return resultMap.get(prices.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit121().maxProfit(new int[]{7,1,5,3,6,4}));
    }


}
