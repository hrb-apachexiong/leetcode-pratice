package leetcode.linkedlist;// --------------------- Change Logs----------------------

// <p>@author bjhexiong Initial Created at 2020-05-11<p>
// 注释说明
// -------------------------------------------------------
public class MyLinkedList707 {

    class Node<T> {
        Node next;
        Node before;

        T value;
    }

    volatile int size = 0;

    Node<Integer> first = new Node<>();
    Node<Integer> tail = new Node<>();

    /** Initialize your data structure here. */
    public MyLinkedList707() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node<Integer> node = first;
        int i = 0;
        while (++i <= index) {
            node = node.next;
        }
        return node.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node<Integer> node = new Node<>();
        node.value = val;

        if (size == 0) {
            emptyAdd(node);
        } else {
            first.next.before = node;
            node.next = first.next;
            first = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node<Integer> node = new Node<>();
        node.value = val;

        if (size == 0) {
            emptyAdd(node);
        } else {
            tail.before.next = node;
            node.before = tail.before.next;
            tail = node;
        }
        size++;
    }

    private void emptyAdd(Node<Integer> node) {
        first.next = node;
        tail.before = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node<Integer> node = new Node<>();
        node.value = val;

        if (size == 0) {
            emptyAdd(node);
        } else {
            Node<Integer> before = first;
            int i = 0;
            while (++i < index) {
                before = before.next;
            }

            if (before.next == null) {
                addAtTail(val);
            } else {
                node.next = before.next;
                before.next.before = node;

                node.before = before;
                before.next = node;
            }
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index > size) {
//            return;
//        }
//        if (size == 1) {
//            first.next = null;
//            tail.before = null;
//        }else if (index == 0) {
//            first.next.next.before = null;
//            first.next = first.next.next;
//        } else if (index == (size - 1)) {
//            tail.before = tail.before.before;
//            tail.before
//            tail.before.before == null;
//            tail.before
//
//        }
//
//
//        Node<Integer> before = first;
//        int i = 0;
//        while (++i < index) {
//            before = before.next;
//        }
//
//    }
}
