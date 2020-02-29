package leetcode;

import java.util.Arrays;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-17<p>
// 注释说明
// -------------------------------------------------------
public class ThreeSumCloset {

    public static void main(String[] args) {
        int nums[] = new int[]{-1,2,1,-4};
        int target = 1;

        int closet = new ThreeSumCloset().threeSumClosest(nums, target);
        System.out.println(closet);
    }

    public int threeSumClosest(int[] nums, int target) {
        Integer closet = null;
        int mark = 1;

        Arrays.sort(nums);

        if (nums[0] > target) {
            return nums[0] + nums[1] + nums[2];
        }
        if (nums[nums.length - 1] < target) {
            return nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int cs = nums[i] + nums[j] + nums[k] - target;
                    if (cs < 0) {
                        cs = -1 * cs;
                        if (closet == null || closet > cs) {
                            closet = cs;
                            mark = -1;
                        }
                    } else {
                        if (closet == null || closet > cs) {
                            closet = cs;
                            mark = 1;
                        }
                    }
                }
            }
        }
        return target + mark * closet;
    }
}
