package practice;

import java.util.Arrays;

public class TestDS {
    public static void main(String[] args) {
//        String a = "123";
//        StringBuffer b;
//        b.reverse();
//        LinkedList
//        StringBuffer
        int[] nums = {1,2,3,1,2,3,1,2,3};
        System.out.println(findNumberOfLIS(nums));


    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[]count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int res = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                    else if(dp[j]+1>dp[i]){
                        count[i]=count[j];
                        dp[i] = dp[j]+1;
                    }

                }
            }
            res = Math.max(res,dp[i]);
        }
        int countR = 0;
        for(int i = 0;i<n;i++){
            if(dp[i]==res){
                countR+=count[i];
            }
        }
        return countR;
    }
}
