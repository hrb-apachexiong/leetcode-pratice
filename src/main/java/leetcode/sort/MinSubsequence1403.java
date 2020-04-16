package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-12<p>
// 注释说明
// -------------------------------------------------------
public class MinSubsequence1403 {

    public static void main(String[] args) {
        List<Integer> result = new MinSubsequence1403().minSubsequence(new int[]{6,6});
        System.out.println(result);
    }

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sub = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            int idx = -1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    idx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            result.add(max);
            sub += max;
            if (sub > sum / 2) {
                return result;
            }

        }
        return result;
    }
}
