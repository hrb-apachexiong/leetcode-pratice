package leetcode;

import java.util.*;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-16<p>
// 注释说明
// 核心是递归，重点是查找剪枝。
// -------------------------------------------------------
public class ThreadSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) {
            return result;
        }

        Set<String> dup = new HashSet<String>();

        Map<Integer, Integer> searchMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!searchMap.containsKey(nums[i])) {
                searchMap.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int searchValue = 0 - sum;
                Integer value = searchMap.get(searchValue);
                if (null != value) {
                    if (value != i && value != j) {
                        int[] sorted = new int[]{nums[i], nums[j], nums[value]};
                        Arrays.sort(sorted);
                        String key = sorted[0] + "" + sorted[1] + "" + sorted[2];
                        if (!dup.contains(key)) {
                            List<Integer> node = new ArrayList<Integer>();
                            node.add(nums[i]);
                            node.add(nums[j]);
                            node.add(nums[value]);
                            result.add(node);
                            dup.add(key);
                        }
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] testcase = new int[]{-1, 0, 1, 2, -4};
        List<List<Integer>> result = new ThreadSum().threeSum(testcase);
        System.out.println(result);
    }
}
