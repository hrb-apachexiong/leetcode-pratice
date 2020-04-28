package leetcode.sort;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-20<p>
// 注释说明
// -------------------------------------------------------
public class InsertionSortList147 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(-1);
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(0);

        first.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode node = new InsertionSortList147().insertionSortList(first);
        System.out.println(node);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        //init
        ListNode sorted = head;
        sorted.next = null;

        while (node != null) {
            ListNode thisNode = node;
            node = node.next;

            //search pos
            ListNode posBefore = null;
            ListNode posAfter = sorted;
            while (posAfter.next != null && posAfter.val <= thisNode.val) {
                posBefore = posAfter;
                posAfter = posAfter.next;
            }

            //insert
            if (posBefore == null) {
                if (posAfter.val > thisNode.val) {
                    thisNode.next = posAfter;
                    sorted = thisNode;
                }else{
                    posAfter.next = thisNode;
                    thisNode.next = null;
                }
            } else if (posAfter.next == null && posAfter.val <= thisNode.val) {
                posAfter.next = thisNode;
                thisNode.next = null;
            } else {
                posBefore.next = thisNode;
                thisNode.next = posAfter;
            }
        }
        return sorted;
    }
}
