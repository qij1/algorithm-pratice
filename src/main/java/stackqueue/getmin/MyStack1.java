package stackqueue.getmin;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if(newNum < getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public Integer getMin() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }
}
