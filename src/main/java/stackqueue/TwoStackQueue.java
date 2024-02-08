package stackqueue;

import java.util.Stack;

/**
 * 2.两个栈组成的队列
 */
public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    private void pushToPop(){
        if(stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        twoStackQueue.add(5);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());


    }
}
