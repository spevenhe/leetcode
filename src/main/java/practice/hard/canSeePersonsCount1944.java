package practice.hard;

import java.util.LinkedList;
import java.util.Stack;

public class canSeePersonsCount1944 {

    public static void main(String[] args) {

        int[] heights = {10,6,8,5,11,9};
        int[] rs = canSeePersonsCount(heights);
        for(int r : rs){
            System.out.println(r);
        }

    }
    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        LinkedList<Integer>stack = new LinkedList<>();
        int[] ans  = new int[n];
        for(int i = n-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peekFirst() < heights[i]){
                stack.removeFirst();
                ans[i]++;

            }
            if(!stack.isEmpty()){
                ans[i]+=1;
            }
            stack.addFirst(heights[i]);
        }
        return ans;
    }

}
