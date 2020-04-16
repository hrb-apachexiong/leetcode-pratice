package leetcode.sort;

import java.util.HashMap;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-11<p>
// 注释说明
// -------------------------------------------------------
public class SortByBits1356 {
    public static void main(String[] args) {
        int[] re = new SortByBits1356().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(re);

    }

    public int[] sortByBits(int[] arr) {
        int[] bits = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            int slot = arr[i];
            int bitSize = 0;
            while (slot > 0) {
                if ((slot & 1) == 1) {
                    bitSize++;
                }
                slot = slot >> 1;
            }
            bits[i] = bitSize;
        }


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int bitI = bits[arr[i]];
                int bitJ = bits[arr[j]];

                if (bitI > bitJ || (bitI == bitJ && arr[i] > arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
