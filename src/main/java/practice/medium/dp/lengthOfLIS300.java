package practice.medium.dp;

import java.util.Arrays;

public class lengthOfLIS300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int rs = 0;
        for(int i = 0;i< n;i++){
            for(int j = 0;j< i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            rs = Math.max(rs, dp[i]);
        }

        return rs;

    }
}
