package leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-18<p>
// 注释说明
// -------------------------------------------------------
public class Subsets78 {

    public static void main(String[] args) {
        System.out.println(new Subsets78().subsets(new int[]{1,2,3}));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(new LinkedList<>(), nums, 0);
        return result;
    }

    public void backtrace(LinkedList<Integer> tracer, int[] nums, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(tracer));
            return;
        }

        //add
        tracer.add(nums[index]);
        backtrace(tracer, nums, index+1);
        tracer.removeLast();

        //not add
        backtrace(tracer, nums, index+1);
    }


}
