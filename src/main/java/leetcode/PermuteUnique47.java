package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-23<p>
// 注释说明
// -------------------------------------------------------
public class PermuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> resultFr = new ArrayList<Integer>();
        resultFr.add(nums[0]);
        result.add(resultFr);
        for (int i = 1; i < nums.length; i++) {
            result = permuteUnique(result, nums[i]);
        }
        return result;
    }

    public List<List<Integer>> permuteUnique(List<List<Integer>> resultBf, Integer num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> resultList : resultBf) {
            for (int i = 0; i <= resultList.size(); i++) {
                List<Integer> resultListNew = new ArrayList<Integer>(resultList);
                if (i == 0 || !resultListNew.get(i - 1).equals(num)) {
                    resultListNew.add(i, num);
                    result.add(resultListNew);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 4, 6, 2};
        List<List<Integer>> result = new PermuteUnique47().permuteUnique(nums);
        System.out.println(result);
    }


}
