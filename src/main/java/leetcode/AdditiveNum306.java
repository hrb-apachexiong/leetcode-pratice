package leetcode;

import com.sun.org.apache.bcel.internal.generic.FSUB;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-03<p>
// 注释说明
// -------------------------------------------------------
public class AdditiveNum306 {

    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() / 2; i++) {
            String firstNum = num.substring(0, i + 1);
            if (firstNum.length() > 1 && firstNum.startsWith("0")) {
                continue;
            }
            boolean rst = backtrace(num, i + 1, Long.parseLong(firstNum));
            if (rst) {
                return true;
            }
        }
        return false;

    }

    public boolean backtrace(String num, int index, long firstNum) {
        int firstNumLength = String.valueOf(firstNum).length();
        if (num.length() - index < firstNumLength) {
            return false;
        }

        //true的条件 都是成立，后面没有了。
        for (int i = index + 1; i <= num.length() - firstNumLength; i++) {
            int meetCondOrEnd = meetCond(num, index, i, firstNum);
            if (meetCondOrEnd == -1) {
                continue;
            }
            //结束条件
            if (meetCondOrEnd == 0) {
                return true;
            }

            boolean rst = backtrace(num, i, Long.parseLong(num.substring(index, i)));
            if (rst == true) {
                return true;
            }
        }
        return false;
    }

    public int meetCond(String num, int from, int to, long firstNum) {
        String secondNumStr = num.substring(from, to);
        long secondNum = Long.parseLong(secondNumStr);
        if (secondNumStr.length() > 1 && secondNumStr.startsWith("0")) {
            return -1;
        }
        long sum = secondNum + firstNum;

        String suffix = num.substring(to);
        if (!suffix.startsWith(String.valueOf(sum))) {
            return -1;
        }
        return suffix.length() - String.valueOf(sum).length();
    }


    public static void main(String[] args) {
        System.out.println(new AdditiveNum306().isAdditiveNumber("0235813"));
    }
}
