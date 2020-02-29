package leetcode;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-22<p>
// 注释说明
// -------------------------------------------------------
public class BinaryPlusSearch {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            if(target == nums[start]){
                return start;
            }
            if(target ==nums[end]){
                return end;
            }
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;}

            if(nums[start] < nums[mid]){
                if(nums[mid] > target && nums[start] < target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target < nums[end]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] searchArray = new int[]{4,5,6,0,1,2};
        int[] searchArray = new int[]{1,2,3,4,5,6,7};
        int target = 5;
        System.out.println(new BinaryPlusSearch().search(searchArray, target));
    }
}
