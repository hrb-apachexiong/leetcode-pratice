package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-06<p>
// 注释说明
// -------------------------------------------------------
public class LargestPerimeter976 {
    public static void main(String[] args) {
        System.out.println(new LargestPerimeter976().largestPerimeter(new int[]{3,6,2,3}));
    }

    public int largestPerimeter(int[] a) {
        //sort descent
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        //check
        int result = -1;
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] < a[i + 1] + a[i + 2]) {
                result = a[i] + a[i + 1] + a[i + 2];
            }
        }
        return result;
    }
}
