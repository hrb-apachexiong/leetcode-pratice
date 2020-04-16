package leetcode.sort;

import java.util.Arrays;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-12<p>
// 注释说明
// -------------------------------------------------------
public class WiggleSort324 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 3, 1};
        new WiggleSort324().wiggleSort(nums);
        System.out.println(nums);
    }


    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] result = new int[nums.length];

        int idxEnd = nums.length - 1;
        int idxStart = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[idxStart--];
            } else {
                result[i] = nums[idxEnd--];
            }
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
