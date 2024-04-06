package practice.medium;

public class rob198 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,9,3,1};
        int[] nums = new int[]{1,1};
        int res = rob(nums);
        System.out.println(res);
    }
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        dp[0] = nums[0];
        if(n<=2){
            dp[1] = Math.max(dp[0],nums[1]);
            return dp[n-1];
        }
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
