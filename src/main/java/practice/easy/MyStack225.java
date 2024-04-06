package practice.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MyStack225 {

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        int a = ms.pop();
        int a2 =ms.pop();
        int a3 =ms.pop();
    }

}


class MyStack {
    Deque<Integer> list1 = new LinkedList<>();

    Deque<Integer> list2 = new LinkedList<>();
    int top;
    public MyStack() {

    }

    public void push(int x) {
        list1.addLast(x);
        top = x;
    }

    public int pop() {

        while (list1.size()>1){
            list2.addLast(list1.pollFirst());
        }
        int topOld = top;
        if(list2.size()>0){
            top = list2.peekLast();
        }
        list1.pollFirst();
        Deque<Integer> tmp = list1;
        list1 = list2;
        list2 = tmp;

        return topOld;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return list1.isEmpty();
    }
}
