package leetcode.search;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-27<p>
// 注释说明
// -------------------------------------------------------
public class DoubleSearch33 {
    public static void main(String[] args) {
        int s = new DoubleSearch33().search(new int[]{4, 2}, 2);
        System.out.println(s);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // a b c
            //a段
            if (nums[mid] >= nums[start]) {
                if (target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
