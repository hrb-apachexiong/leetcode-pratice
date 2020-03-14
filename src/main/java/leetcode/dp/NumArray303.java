package leetcode.dp;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-14<p>
// 注释说明
// -------------------------------------------------------
public class NumArray303 {

    public static void main(String[] args) {
        System.out.println(new NumArray303(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 2));
    }

    int[] numSum = null;

    int[] nums = null;

    public NumArray303(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        this.nums = nums;
        numSum = new int[nums.length];
        numSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numSum[i] = nums[i] + numSum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return numSum[j] - numSum[i] + nums[i];
    }
}
