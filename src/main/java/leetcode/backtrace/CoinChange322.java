package leetcode.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-29<p>
// 注释说明
// -------------------------------------------------------
public class CoinChange322 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new CoinChange322().coinChange(new int[]{1,2,5}, 11));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        backtrace(coins, amount, 0, 0, 0);
        if (coinNum != Integer.MAX_VALUE) {
            return coinNum;
        }
        return -1;
    }

    int coinNum = Integer.MAX_VALUE;

    boolean flat = false;

    public void backtrace(int[] conins, int amount, int sum, int coinN, int idx) {
        if (sum == amount) {
            if (coinN < coinNum) {
                coinNum = coinN;
                flat = true;
            }
            return;
        }
        if (flat || idx == conins.length || coinN >= coinNum) {
            return;
        }

        for (int cnt = 0; cnt <= (amount - sum) / conins[idx]; cnt++) {
            backtrace(conins, amount, sum + cnt * conins[idx], coinN + cnt, idx + 1);
        }
    }
}
