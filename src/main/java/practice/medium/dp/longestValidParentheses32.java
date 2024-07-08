package practice.medium.dp;

import java.util.Stack;

public class longestValidParentheses32 {

    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer>stack = new Stack<>();
        int res = 0;
        int[] dp = new int[chars.length+1];
        for(int i = 0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }else{ //')'
                if(!stack.isEmpty() ){
                    int left = stack.pop();
                    int length = i - left + 1;
                    dp[i+1] = length+dp[left];
                    res = Math.max(res,dp[i+1]);
                }
            }
        }
        return res;

    }
}
