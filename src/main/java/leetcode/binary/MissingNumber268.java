package leetcode.binary;// --------------------- Change Logs----------------------

// <p>@author bjhexiong Initial Created at 2020-05-14<p>
// 注释说明
// -------------------------------------------------------
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int result = 0;
        result ^= nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}
