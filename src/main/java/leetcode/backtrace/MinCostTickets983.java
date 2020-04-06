package leetcode.backtrace;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-02<p>
// 注释说明
// -------------------------------------------------------
public class MinCostTickets983 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] a = new int[]{6, 9, 10, 14, 15, 16, 17, 18, 20, 22, 23, 24, 29, 30, 31, 33, 35, 37, 38, 40, 41, 46, 47, 51, 54, 57, 59, 65, 70, 76, 77, 81, 85, 87, 90, 91, 93, 94, 95, 97, 98, 100, 103, 104, 105, 106, 107, 111, 112, 113, 114, 116, 117, 118, 120, 124, 128, 129, 135, 137, 139, 145, 146, 151, 152, 153, 157, 165, 166, 173, 174, 179, 181, 182, 185, 187, 188, 190, 191, 192, 195, 196, 204, 205, 206, 208, 210, 214, 218, 219, 221, 225, 229, 231, 233, 235, 239, 240, 245, 247, 249, 251, 252, 258, 261, 263, 268, 270, 273, 274, 275, 276, 280, 283, 285, 286, 288, 289, 290, 291, 292, 293, 296, 298, 299, 301, 303, 307, 313, 314, 319, 323, 325, 327, 329, 334, 339, 340, 341, 342, 344, 346, 349, 352, 354, 355, 356, 357, 358, 359, 363, 364};
        System.out.println(new MinCostTickets983().mincostTickets(a, new int[]{21, 115, 345}));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int mincostTickets(int[] days, int[] costs) {
        backtrace(days, costs, 0, 0);
        return min;
    }

    int min = Integer.MAX_VALUE;

    public void backtrace(int[] days, int[] costs, int idx, int cost) {
        if (cost > min) {
            return;
        }
        if (idx == days.length) {
            if (min > cost) {
                min = cost;
            }
            return;
        }

        //30
        int des = idx + 1;
        for (int i = idx + 1; i < days.length; i++) {
            des = i + 1;
            if (days[i] - days[idx] + 1 > 30) {
                des = i;
                break;
            }
        }
        backtrace(days, costs, des, cost + costs[2]);

        //7
        des = idx + 1;
        for (int i = idx + 1; i < days.length; i++) {
            des = i + 1;
            if (days[i] - days[idx] + 1 > 7) {
                des = i;
                break;
            }
        }
        backtrace(days, costs, des, cost + costs[1]);

        //1天
        backtrace(days, costs, idx + 1, cost + costs[0]);
    }
}
