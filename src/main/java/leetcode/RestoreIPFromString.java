package leetcode;

import java.util.ArrayList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-24<p>
// 注释说明
// -------------------------------------------------------
public class RestoreIPFromString {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> result = searchIP(s, 0, "", 4);
        return result;
    }

    public List<String> searchIP(String s, int index, String prefix, int node) {
        List<String> result = new ArrayList<String>();
        if ((s.length() - index + 1) < node) {
            return result;
        }
        if (node == 1) {
            String value = s.substring(index, s.length());
            if (value.length() == 0 || (value.startsWith("0") && value.length() > 1)) {
                return result;
            }
            int num = Integer.parseInt(value);
            if (num <= 255 && num >= 0) {
                result.add(prefix + "." + value);
                return result;
            }
            return result;
        }

        int length = 3;
        if (length > (s.length() - index + 1 - node + 1)) {
            length = s.length() - index + 1 - (node - 1);
        }
        if (length <= 1) {
            return result;
        }

        for (int i = length; i > 0; i--) {
            String thisNode = s.substring(index, index + i);
            int num = Integer.parseInt(thisNode);
            //
            if (thisNode.length() > 1 && thisNode.startsWith("0")) {
                continue;
            }
            if (num <= 255) {
                String value = thisNode;
                if (node != 4) {
                    value = prefix + "." + thisNode;
                }

                List<String> rs = searchIP(s, index + i, value, node - 1);
                if (rs.size() > 0) {
                    result.addAll(rs);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "010010";
        System.out.println(new RestoreIPFromString().restoreIpAddresses(s));
    }


}
