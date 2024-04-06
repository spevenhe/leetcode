package practice.medium.dp;

public class maxSubArray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i-1], nums[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
