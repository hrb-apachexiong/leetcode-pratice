package leetcode.linkedlist;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-22<p>
// 注释说明
// -------------------------------------------------------
public class ReverseList24 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode result = head;
        ListNode node = head.next;
        while (node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        head.next = null;
        return result;
    }
}
