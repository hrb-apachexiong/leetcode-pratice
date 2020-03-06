package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import java.util.*;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-01<p>
// 注释说明
// -------------------------------------------------------
public class LetterPhoneNum17 {

    private static final Map<Integer, List<String>> numIntMap = new HashMap<>();

    static {
        for (int i = 2; i < 10; i++) {
            List<String> nums;
            switch (i) {
                case 2:
                    nums = new ArrayList<>();
                    nums.add("a");
                    nums.add("b");
                    nums.add("c");
                    numIntMap.put(2, nums);
                    break;
                case 3:
                    nums = new ArrayList<>();
                    nums.add("d");
                    nums.add("e");
                    nums.add("f");
                    numIntMap.put(3, nums);
                    break;
                case 4:
                    nums = new ArrayList<>();
                    nums.add("g");
                    nums.add("h");
                    nums.add("i");
                    numIntMap.put(4, nums);
                    break;
                case 5:
                    nums = new ArrayList<>();
                    nums.add("j");
                    nums.add("j");
                    nums.add("l");
                    numIntMap.put(5, nums);
                    break;
                case 6:
                    nums = new ArrayList<>();
                    nums.add("m");
                    nums.add("n");
                    nums.add("o");
                    numIntMap.put(6, nums);
                    break;
                case 7:
                    nums = new ArrayList<>();
                    nums.add("p");
                    nums.add("q");
                    nums.add("r");
                    nums.add("s");
                    numIntMap.put(7, nums);
                    break;
                case 8:
                    nums = new ArrayList<>();
                    nums.add("t");
                    nums.add("u");
                    nums.add("v");
                    numIntMap.put(8, nums);
                    break;
                case 9:
                    nums = new ArrayList<>();
                    nums.add("w");
                    nums.add("x");
                    nums.add("y");
                    nums.add("z");
                    numIntMap.put(9, nums);
                    break;
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        backtrace(digits, 0, new LinkedList<>());
        return result;
    }

    List<String> result = new ArrayList<>();

    public void backtrace(String digits, int pos, LinkedList<String> track) {
        if (pos == digits.length()) {
            result.add(String.join("", track));
            return;
        }

        int num = digits.charAt(pos) - '0';
        for (String s : numIntMap.get(num)) {
            track.add(s);
            backtrace(digits, pos + 1, track);
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        System.out.println(new LetterPhoneNum17().letterCombinations("27"));

    }

}
