package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-09<p>
// 注释说明
// -------------------------------------------------------
public class RelativeSortArray1122 {
    public static void main(String[] args) {
        int[] s = new RelativeSortArray1122().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});

        System.out.println(s);


    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] sort = new int[1001];
        int cnt = 0;
        for (int i : arr2) {
            sort[i] = ++cnt;
        }

        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                int a = sort[arr1[i]] == 0 ? arr1[i] + cnt : sort[arr1[i]];
                int b = sort[arr1[j]] == 0 ? arr1[j] + cnt : sort[arr1[j]];
                if (a > b) {
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        return arr1;
    }
}
