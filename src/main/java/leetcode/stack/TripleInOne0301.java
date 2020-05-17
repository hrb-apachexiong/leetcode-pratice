package leetcode.stack;// --------------------- Change Logs----------------------

import java.util.stream.Stream;

// <p>@author bjhexiong Initial Created at 2020-05-11<p>
// 一个数组3个栈
// -------------------------------------------------------
public class TripleInOne0301 {

    public static void main(String[] args) {
        TripleInOne0301 stack = new TripleInOne0301(1);
        stack.push(0, 1);
        stack.push(0, 2);

        System.out.println(stack.pop(0));


    }

    int[] store = null;

    int firstPos = 0;
    int secondPos = 0;
    int thirdPos = 0;

    int stackSize = 0;

    public TripleInOne0301(int stackSize) {
        store = new int[stackSize * 3];
        for (int i = 0; i < stackSize * 3; i++) {
            store[i] = -1;
        }
        secondPos = stackSize;
        thirdPos = stackSize * 2;
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        switch (stackNum) {
            case 0:
                if (firstPos != stackSize) {
                    store[firstPos] = value;
                    firstPos++;
                }
                break;
            case 1:
                if (secondPos != stackSize * 2) {
                    store[secondPos] = value;
                    secondPos++;
                }
                break;
            case 2:
                if (thirdPos != stackSize * 3) {
                    store[thirdPos] = value;
                    thirdPos++;
                }
                break;
        }
    }

    public int pop(int stackNum) {
        int result = -1;
        switch (stackNum) {
            case 0:
                if (firstPos != 0) {
                    result = store[--firstPos];
                    store[firstPos] = -1;
                }
                break;
            case 1:
                if (secondPos != stackSize) {
                    result = store[--secondPos];
                    store[secondPos] = -1;
                }
                break;
            case 2:
                if (thirdPos != stackSize * 2) {
                    result = store[--thirdPos];
                    store[thirdPos] = -1;
                }
                break;
        }
        return result;
    }

    public int peek(int stackNum) {
        int result = -1;
        switch (stackNum) {
            case 0:
                if (firstPos != 0) {
                    result = store[firstPos - 1];
                }
                break;
            case 1:
                if (secondPos != stackSize) {
                    result = store[secondPos - 1];
                }
                break;
            case 2:
                if (thirdPos != stackSize * 2) {
                    result = store[thirdPos - 1];
                }
                break;
        }
        return result;
    }

    public boolean isEmpty(int stackNum) {
        switch (stackNum) {
            case 0:
                return firstPos == stackSize * 0;
            case 1:
                return secondPos == stackSize * 1;
            case 2:
                return thirdPos == stackSize * 2;
        }
        return false;
    }
}
