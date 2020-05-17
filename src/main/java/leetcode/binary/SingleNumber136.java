package leetcode.binary;// --------------------- Change Logs----------------------

// <p>@author bjhexiong Initial Created at 2020-05-14<p>
// 注释说明
// -------------------------------------------------------
public class SingleNumber136 {


    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums){
            result ^= num;
        }
        return result;
    }
}
