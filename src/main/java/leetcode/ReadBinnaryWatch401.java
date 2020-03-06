package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadBinnaryWatch401 {

    public static void main(String[] args) {

        System.out.println(new ReadBinnaryWatch401().readBinaryWatch(2));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrace(num, new LinkedList<>());

        //处理结果
        List<String> rst = new ArrayList<>();
        for (List<Integer> time : result) {
            int hour = 0;
            int minutes = 0;
            for (int i = 0; i < 10; i++) {
                if (i <= 3) {
                    hour += time.get(i) * Math.pow(2, i);
                } else {
                    minutes += time.get(i) * Math.pow(2, i - 4);
                }
            }
            rst.add(String.format("%d:%02d", hour, minutes));
        }
        return rst;
    }

    public void backtrace(int num, LinkedList<Integer> track) {
        if (track.size() == 10) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i <= 1; i++) {
            //check
            if (!checkNum(track, i, num, 10)) {
                continue;
            }
            track.add(i);
            backtrace(num, track);
            track.removeLast();
        }
    }

    public boolean checkNum(LinkedList<Integer> track, int num, int psize, int tabsize) {
        int blankSize = tabsize - track.size();
        int count = 0;
        for (int binary : track) {
            if (binary == 1) {
                count++;
            }
        }
        // check hou是否超过12点
        if (track.size() == 3 && num == 1) {
            if (track.get(2) == 1) {
                return false;
            }
        }
        // check minute是否超过59
        if (track.size() == tabsize - 1 && num == 1) {
            if (track.get(tabsize - 2) == 1
                    && track.get(tabsize - 3) == 1
                    && track.get(tabsize - 4) == 1) {
                return false;
            }
        }

        //剩下空间
        if ((psize - count) > (tabsize - track.size())) {
            return false;
        }
        if (num == 1) {
            if (count >= psize) {
                return false;
            }
        } else {
            if ((psize - count) == (tabsize - track.size())) {
                return false;
            }
        }
        return true;
    }
}
