package practice.medium.dp;

public class rob213 {
    public static void main(String[] args) {
        int[] input = {1,2,3,1};
        int res =rob(input);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        int res1 = dp(dp1,0,n-2,nums);
        int res2 = dp(dp2,1,n-1,nums);
        return Math.max(res1, res2);


    }

    public static int dp(int[] dp, int start, int end, int[] nums){
        int res = 0;
        dp[start+1] = nums[start];
        res = dp[start+1];
        for(int i = start+1;i<=end;i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
            res = Math.max(res,dp[i+1]);
        }
        return res;

    }


    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i<=n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n];

    }


}
