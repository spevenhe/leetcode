package practice;

import java.util.*;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Queue<Integer> queue1;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        queue1 = new LinkedList<>();
        queue1.isEmpty();

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() || stack1.isEmpty();
    }
}