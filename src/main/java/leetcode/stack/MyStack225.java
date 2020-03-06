package leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-03-01<p>
// 注释说明
// -------------------------------------------------------
public class MyStack225 {

    private LinkedList<Integer> stackStore;

    /** Initialize your data structure here. */
    public MyStack225() {
        stackStore = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        stackStore.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stackStore.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return stackStore.getLast();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stackStore.isEmpty();
    }

}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
