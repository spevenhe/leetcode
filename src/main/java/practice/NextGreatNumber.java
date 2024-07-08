package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class NextGreatNumber {
    public static void main(String[] args) {
        int[] nums = {2,1,2,4,3};
        System.out.println(Arrays.toString(monoStack(nums)));

    }
    public static int[] monoStack(int[] nums){
        Stack<Integer>stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:nums[stack.peek()];
            stack.push(i);
        }
        return res;
    }
}
