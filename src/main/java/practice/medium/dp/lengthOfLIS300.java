package practice.medium.dp;

import java.util.Arrays;

public class lengthOfLIS300 {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;

    }
}
