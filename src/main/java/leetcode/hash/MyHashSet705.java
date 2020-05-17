package leetcode.hash;// --------------------- Change Logs----------------------

import java.util.ArrayList;
import java.util.List;

// <p>@author bjhexiong Initial Created at 2020-05-11<p>
// 注释说明 hash函数 是用hashcode
// -------------------------------------------------------
public class MyHashSet705 {

    public static void main(String[] args) {
        MyHashSet705 set = new MyHashSet705();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
    }


    //线性探测法

    //扩容问题

    int size = 0;

    int capacity = 16;

    float loadFactor = 0.75f;

    List<Integer> slot = new ArrayList<>(capacity);

    /** Initialize your data structure here. */
    public MyHashSet705() {

    }

    private void expandSlot() {
        int newCapacity = capacity * 2;
        List<Integer> oldStore = slot;
        slot = new ArrayList<>(newCapacity);
        capacity = newCapacity;

        for (Integer value : slot) {
            add(value);
        }
    }


    public void add(int key) {
        if ((size + 1) / (1.0 * capacity) > loadFactor) {
            expandSlot();
        }
        int slotIdx = key % capacity;

        //store
        int start = slotIdx;
        while (true) {
            if (slot.get(start) == null) {
                slot.set(start, key);
                return;
            } else if (slot.get(start) == key) {
                return;
            } else {
                if (start == (capacity - 1)) {
                    start = 0;
                } else {
                    start++;
                }
            }
        }
    }

    public void remove(int key) {
        int slotIdx = key % capacity;

        //store
        int start = slotIdx;
        boolean arange = false;
        while (true) {
            if (slot.get(start) == null) {
                break;
            }
            if (key == slot.get(start)) {
                slot.set(start, null);
                arange = true;
                break;
            }

            if (start == (capacity - 1)) {
                start = 0;
            } else {
                start++;
            }
        }
        if (!arange) {
            return;
        }
        int arrangeStart = start + 1;
        Integer lastOne = null;
        int lastIdx = -1;
        //arrangement
        while (true) {
            Integer value = slot.get(arrangeStart);
            if (value == null) {
                break;
            }
            if (value % capacity == slotIdx) {
                lastOne = value;
                lastIdx = arrangeStart;
            }
            if (arrangeStart == (capacity - 1)) {
                arrangeStart = 0;
            } else {
                arrangeStart++;
            }
        }

        if (lastOne != null) {
            slot.set(lastIdx, null);
            slot.set(start, lastOne);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        boolean result = false;
        int slotIdx = key % capacity;

        //store
        int start = slotIdx;
        while (true) {
            if (slot.get(start) == null) {
                result = false;
                break;
            }
            if (key == slot.get(start)) {
                result = true;
                break;
            } else {
                if (start == (capacity - 1)) {
                    start = 0;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
