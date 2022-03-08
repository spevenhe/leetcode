package practice;

import java.util.Stack;

public class largestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int[] nums = new int[n+2];
        for(int i = 0;i<n;i++){
            nums[i+1] = heights[i];
        }
        stack.push(n+1);
//        int[] a1 = new int[n+2];
        for(int i = n;i>=1;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                int cur = stack.pop();
                int right = stack.peek()-1;
                res = Math.max(res,(right-i)*nums[cur]);
            }
//            if(!stack.isEmpty()){
//                a1[i] = nums[stack.peek()];
//            }

            stack.push(i);

        }
        System.out.println(res);
    }

}
