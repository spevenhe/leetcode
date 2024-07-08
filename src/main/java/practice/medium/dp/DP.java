package practice.medium.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DP {

    public static void main(String[] args) {
//        boolean rs = wordBreak("a", Arrays.asList("a"));
        int[] input = {1,2,5};
        boolean rs = canPartition(input);
        System.out.println(rs);
    }


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 0;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }else{
                    break;
                }
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                if(dp[j] && dict.contains(s.substring(j,i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = false;
        for(int i = 1;i<=nums.length;i++){
            for(int j = 1;j<=target;j++){
                if(nums[i-1] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
                else if(nums[i-1] == j){
                    dp[i][j] = true;
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1;j<n;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {
        char[] wordChars1 = word1.toCharArray();
        char[] wordChars2 = word2.toCharArray();
        int m = wordChars1.length;
        int n = wordChars2.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 0;i<m;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j<n;j++){
            dp[0][j] = j;
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(wordChars1[i-1] == wordChars2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
