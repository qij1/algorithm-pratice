package stackqueue.getmin;

import java.util.Stack;

/**
 * 1.设计有getMin功能的栈
 */
public class MyStack1 {
    private static Stack<Integer> stackData;
    private static Stack<Integer> stackMin;

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        System.out.println("入栈");
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(1);
        stack1.push(6);
        System.out.println("获得最小值");
        System.out.println(getMin());

        System.out.println("出栈");
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());


    }

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public static void push(int newNum) {
        if(stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if(newNum < getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public static Integer getMin() {
        if(stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }

    public static int pop() {
        if(stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = stackData.pop();
        if(value == getMin()) {
            stackMin.pop();
        }
        return value;
    }
}
