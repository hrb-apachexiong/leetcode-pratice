package leetcode.linkedlist;// --------------------- Change Logs----------------------

// <p>@author bjhexiong Initial Created at 2020-05-10<p>
// 注释说明
// -------------------------------------------------------
public class etKthFromEndMeet22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        if(k==1){
            while(node.next != null){
                node = node.next;
            }
            return node;
        }

        ListNode endP = head;
        for (int i = 0; i < k; i++) {
            if (endP == null) {
                return null;
            }
            endP = head.next;
        }
        while (endP.next != null) {
            node = node.next;
            endP = endP.next;
        }
        return node;

    }
}
