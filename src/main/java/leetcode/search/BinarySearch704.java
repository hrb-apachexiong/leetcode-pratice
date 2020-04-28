package leetcode.search;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-28<p>
// 注释说明
// -------------------------------------------------------
public class BinarySearch704 {

    public static void main(String[] args) {
        System.out.println(new BinarySearch704().search(new int[]{1, 2, 3, 4, 5, 6}, 6));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
