package practice.medium.dp;

import java.util.Arrays;

public class count2719 {

    public static void main(String[] args) {

    }
    private static final int MOD = 1_000_000_007;
    public int count(String num1, String num2, int minSum, int maxSum) {
        int ans = calc(num2, minSum, maxSum) - calc(num1, minSum, maxSum) + MOD; // 避免负数
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum) {
            ans++; // num1 是合法的，补回来
        }
        return ans % MOD;
    }

    public int calc(String s, int minSum, int maxSum){
        int n = s.length();
        int[][] dp = new int[n][maxSum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,0,true,s.toCharArray(),minSum,maxSum,dp);
    }

    public int dfs(int i, int sum, boolean isLimit, char[] sc, int min, int max,int[][]dp){
        if(sum > max){
            return 0;
        }
        if(i == sc.length){
            if(sum >= min){
                return 1;
            }else{
                return 0;
            }
        }
        if(!isLimit && dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int up = isLimit?sc[i]-'0':9;
        int res = 0;
        for(int index = 0;index <= up;index++){
            res+=dfs(i+1,sum+index,isLimit&& index==up,sc,min,max,dp);
        }

        if(!isLimit){
            dp[i][sum] = res;
        }
        return res;
    }
}
