package practice.medium;

import java.util.Arrays;

public class productExceptSelf238 {

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] res = productExceptSelf(nums);
        System.out.println(res);
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] res = new int[n];
        leftProduct[0] = 1;
        for(int i = 1;i<n;i++){
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }
        rightProduct[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }

        for(int i = 0;i<n;i++){
            res[i] = leftProduct[i]*rightProduct[i];
        }
        return res;

    }
}
