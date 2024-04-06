package practice.medium;

import java.util.Stack;

public class evalRPN150 {

    public static void main(String[] args) {

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer>stack = new Stack<>();
        for(String token : tokens){
            switch (token){
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d-c);
                    break;
                case "*":
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(e*f);
                    break;
                case "/":
                    int g = stack.pop();
                    int h = stack.pop();
                    stack.push(h/g);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;

            }

        }
        return stack.pop();
    }
}
