package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-22<p>
// 递归
// -------------------------------------------------------
public class Permute46 {

    public List<List<Integer>> permute(int[] nums) {
        Map<String, List<List<Integer>>> cacheMap = new HashMap<String, List<List<Integer>>>();
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<Integer> params = new ArrayList<Integer>(nums.length);
        for (Integer num : nums) {
            params.add(num);
        }
        return permute(params, cacheMap);
    }

//    public List<List<Integer>> permute1(int[] nums) {
//        if (nums.length == 0) {
//            return new ArrayList<List<Integer>>();
//        }
//
//        List<Integer> params = new ArrayList<Integer>(nums.length);
//        for(Integer num : nums){
//            params.add(num);
//        }
//        return permute(params);
//    }

    public List<List<Integer>> permute(List<Integer> nums, Map<String, List<List<Integer>>> cacheMap) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : nums) {
            sb.append(i);
        }
        String key = sb.toString();
        List<List<Integer>> result = cacheMap.get(key);
        if(result != null){
            return result;
        }

        result = new ArrayList<List<Integer>>();
        if (nums.size() == 1) {
            result.add(nums);
            return result;
        } else {
            for (int idx = 0; idx < nums.size(); idx++) {
                List<Integer> numSuffix = new ArrayList<Integer>(nums);
                int prefix = numSuffix.remove(idx);
                List<List<Integer>> subResult = permute(numSuffix, cacheMap);
                for (List<Integer> sr : subResult) {
                    sr.add(0, prefix);
                    result.add(sr);
                }
            }
        }
        cacheMap.put(key, clone(result));
        return result;
    }

    public List<List<Integer>> clone(List<List<Integer>> list) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(list.size());
        for (List<Integer> lt : list) {
            result.add(new ArrayList<Integer>(lt));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 6, 2};
        List<List<Integer>> result = new Permute46().permute(nums);
        System.out.println(result);

    }
}
