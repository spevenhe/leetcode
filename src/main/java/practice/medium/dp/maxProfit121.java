package practice.medium.dp;

public class maxProfit121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n+1];
        dp[0][0] = 0;
        dp[1][0] = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]+prices[i-1]);
            dp[1][i] = Math.max(dp[1][i-1], -prices[i-1]);
        }
        return dp[0][n];

    }

}
