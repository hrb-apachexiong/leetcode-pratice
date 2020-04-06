package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-06<p>
// 注释说明
// -------------------------------------------------------
public class SortArrayByParityII922 {

    public static void main(String[] args) {
        int[] s = new SortArrayByParityII922().sortArrayByParityII(new int[]{4, 2, 5, 7});
        System.out.println(s);
    }

    //double link
    public int[] sortArrayByParityII(int[] a) {
        int[] result = new int[a.length];

        int oIdx = 0, jIdx = 0;
        int idx = 0;
        while (oIdx < a.length && jIdx < a.length) {
            //偶
            for (int i = oIdx; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    result[idx] = a[i];
                    oIdx = i + 1;
                    break;
                }
            }
            idx++;


            //奇
            for (int i = jIdx; i < a.length; i++) {
                if (a[i] % 2 != 0) {
                    result[idx] = a[i];
                    jIdx = i + 1;
                    break;
                }
            }
            idx++;
        }
        return result;

    }
}
