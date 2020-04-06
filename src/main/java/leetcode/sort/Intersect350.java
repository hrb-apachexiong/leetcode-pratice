package leetcode.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-05<p>
// 注释说明
// -------------------------------------------------------
public class Intersect350 {

    public static void main(String[] args) {

        int[] s = new Intersect350().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2, 1});
        System.out.println(s);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums1.length; i++) {
            int num1 = nums1[i];
            for (int j=0; j<nums2.length; j++) {
                int num2 = nums2[j];
                if(num2 == -1){
                    continue;
                }
                if (num1 == num2) {
                    nums2[j] = -1;
                    result.add(num1);
                    break;
                }
            }
        }
        int[] resultArray = new int[result.size()];
        int idx = 0;
        for (Integer re : result) {
            resultArray[idx++] = re;
        }
        return resultArray;
    }
}
