package leetcode.ds;

import java.util.HashMap;
import java.util.LinkedList;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-04<p>
// 注释说明
// -------------------------------------------------------
public class LRUCache146 {
    class Node {
        int key;
        int value;

        public Node before;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node tail;
        Node first;

        public Node removeLast() {
            if (tail == null) {
                return null;
            }
            if (tail == first) {
                Node last = tail;
                first = null;
                tail = null;
                return last;
            }

            Node ret = tail;
            tail = tail.before;
            tail.next = null;
            return ret;
        }

        public void remove(Node node) {
            if (node.before != null && node.next != null) {
                node.before.next = node.next;
                node.next.before = node.before;
            } else if (node.before != null) {
                tail = node.before;
                tail.next = null;
            } else if (node.next != null) {
                first = node.next;
                first.before = null;
            } else {
                first = null;
                tail = null;
            }
        }

        public Node addFirst(int key, int value) {
            Node node = new Node(key, value);
            if (first == null) {
                first = node;
                tail = node;
                return node;
            }
            first.before = node;
            node.next = first;
            first = node;
            return node;
        }
    }

    public static void main(String[] args) {
        LRUCache146 cache = new LRUCache146(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        System.out.println(cache.get(1));       // 返回  1
        System.out.println(cache.get(2));       // 返回  1
        System.out.println(cache.get(3));       // 返回  1
        System.out.println(cache.get(4));       // 返回  1
        System.out.println(cache.get(5));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(1, 4);    // 该操作会使得密钥 1 作废
//
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(1));       // 返回  4

    }

    private HashMap<Integer, Node> store;
    private DoubleLinkedList doubleLinkedList;
    int cap = 0;
    int size = 0;

    public LRUCache146(int capacity) {
        doubleLinkedList = new DoubleLinkedList();
        store = new HashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if (store.containsKey(key)) {
            Node node = store.remove(key);
            doubleLinkedList.remove(node);
            store.put(key, doubleLinkedList.addFirst(node.key, node.value));
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (store.containsKey(key)) {
            Node node = store.remove(key);
            doubleLinkedList.remove(node);
            store.put(key, doubleLinkedList.addFirst(key, value));
        } else if (size + 1 <= cap) {
            store.put(key, doubleLinkedList.addFirst(key, value));
            size++;
        } else {
            store.put(key, doubleLinkedList.addFirst(key, value));
            store.remove(doubleLinkedList.removeLast().key);
        }
    }
}
