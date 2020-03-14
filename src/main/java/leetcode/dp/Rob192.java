package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-09<p>
// 注释说明
// -------------------------------------------------------
public class Rob192 {

    public static void main(String[] args) {
        System.out.println(new Rob192().rob(new int[]{2,7,9,3,1}));
    }

    private static Map<Integer, Integer> resultMap = new HashMap<>();

    public int rob(int[] nums) {
        resultMap.clear();
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        resultMap.put(0, nums[0]);
        resultMap.put(1, Math.max(nums[0], nums[1]));

        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(resultMap.get(i - 1), nums[i] + resultMap.get(i - 2));
            resultMap.put(i, max);
        }
        return resultMap.get(nums.length - 1);
    }
}
