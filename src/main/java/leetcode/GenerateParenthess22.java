package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthess22 {

    List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<String> generateParenthesis(int n) {
        int[] num = new int[]{0, 1};
        LinkedList<Integer> res = new LinkedList<Integer>();
        backtrace(num, n * 2, res);

        //处理结果
        List<String> rs = new ArrayList<String>();
        for(List<Integer> node: result){
            StringBuilder sb = new StringBuilder();
            for(Integer ch : node){
                if(0 == ch){
                    sb.append("(");
                }else{
                    sb.append(")");
                }
            }
            rs.add(sb.toString());
        }
        return rs;
    }

    public void backtrace(int[] num, int size, LinkedList<Integer> track) {
        if (track.size() == size) {
            result.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            //check
            if (!checkTrack(track, num[i], size)) {
                continue;
            }
            track.add(num[i]);
            backtrace(num, size, track);
            track.removeLast();
        }
    }

    public boolean checkTrack(LinkedList<Integer> track, int num, int size) {
        //check个数
        int numCount = 0;
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i) == num) {
                numCount++;
            }
            if (numCount >= size / 2) {
                return false;
            }
        }
        if (num == 1 && (track.size() - numCount) <= numCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        List<String> rt = new GenerateParenthess22().generateParenthesis(3);
        System.out.println(rt);

    }


}
