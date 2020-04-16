package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-15<p>
// 注释说明
// -------------------------------------------------------
public class KClosest973 {
    public static void main(String[] args) {
        int[][] result = new KClosest973().kClosest(new int[][]{{3, 3}, {5,1},{-2, 4}}, 2);
        System.out.println(result);
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] topk = new int[k][2];
        for (int i = 0; i < k; i++) {
            topk[i] = new int[]{10001, 10001};
        }
        for (int i = 0; i < points.length; i++) {
            int[] min = topk[0];
            int[] now = points[i];
            int maxValue = min[0] * min[0] + min[1] * min[1];
            int nowValue = now[0] * now[0] + now[1] * now[1];
            if (nowValue > maxValue) {
                continue;
            }

            //调整顺序.
            topk[0] = now;
            for (int j = 1; j < topk.length; j++) {
                int[] tnow = topk[j];
                int tnowValue = tnow[0] * tnow[0] + tnow[1] * tnow[1];
                if (tnowValue > nowValue) {
                    topk[0] = topk[j];
                    topk[j] = now;
                    now = tnow;
                    nowValue = tnowValue;
                }
            }

        }
        return topk;
    }
}
