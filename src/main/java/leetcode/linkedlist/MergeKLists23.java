package leetcode.linkedlist;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-26<p>
// 注释说明
// -------------------------------------------------------
public class MergeKLists23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode result = null;
        ListNode last = null;


        while (true) {
            int minIdx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (minIdx == -1 || lists[i].val < lists[minIdx].val)) {
                    minIdx = i;
                }
            }

            //break;
            if (-1 == minIdx) {
                break;
            }
            //rem
            ListNode min = lists[minIdx];

            if (null == result) {
                result = min;
                last = min;
            } else {
                last.next = min;
                last = min;
            }

            lists[minIdx] = min.next;
            min.next = null;
        }
        return result;
    }
}
