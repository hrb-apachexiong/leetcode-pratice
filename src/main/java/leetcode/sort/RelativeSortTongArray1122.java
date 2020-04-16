package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-09<p>
// 注释说明
// -------------------------------------------------------
public class RelativeSortTongArray1122 {
    public static void main(String[] args) {

        int[] s = new RelativeSortTongArray1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});

        System.out.println(s);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        int cnt = 0;
        for (int i : arr1) {
            temp[i]++;
        }

        int idx = 0;
        for (int i : arr2) {
            while (temp[i] > 0) {
                arr1[idx++] = i;
                temp[i]--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                arr1[idx++] = i;
            }
        }

        return arr1;
    }
}
