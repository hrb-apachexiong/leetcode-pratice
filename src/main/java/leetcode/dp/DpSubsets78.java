package leetcode.dp;

import leetcode.backtrace.Combine77;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-18<p>
// DP公式
// f(i) = join(f(i-1),z(i)) U f(i-1)
// -------------------------------------------------------
public class DpSubsets78 {

    public static void main(String[] args) {
        System.out.println(new DpSubsets78().subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return new ArrayList<>();
        }
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
            List<List<Integer>> thisResult = new ArrayList<>();
            for(List<Integer> re: result){
                List<Integer> tg = new ArrayList<>(re);
                tg.add(nums[i]);
                thisResult.add(tg);
            }
            result.addAll(thisResult);
        }

        return result;
    }

}
