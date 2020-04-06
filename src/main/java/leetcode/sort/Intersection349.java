package leetcode.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-05<p>
// 注释说明
// -------------------------------------------------------
public class Intersection349 {


    public static void main(String[] args) {

        int[] s = new Intersection349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2, 1});
        System.out.println(s);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int num1 : nums1) {
            if (result.contains(num1)) {
                continue;
            }
            for (int num2 : nums2) {
                if (num1 == num2) {
                    result.add(num1);
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
