package practice.test;

import java.util.Arrays;

public class leetcodeTest {

    public static void main(String[] args) {
//        int[][]grid = {{0,1,0},{1,0,1}};
//        int rs = minimumArea(grid);

//        int[] input = {1,-2,-3,4};
//        long rs = maximumTotalCost(input);
//        System.out.println(rs);

        minimumSum3197 test = new minimumSum3197();
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1}
        };
        int res = test.minimumSum(grid);
        System.out.println(res);

    }

    public double minimumAverage(int[] nums) {
        double rs = Double.MAX_VALUE;
        int first = 0;
        int last = nums.length-1;
        Arrays.sort(nums);
        while(first < last){
            int maxtmp = nums[last];
            int mintmp = nums[first];
            double avgtmp = (maxtmp+mintmp)/2;
            rs = Math.min(avgtmp, rs);
            first++;
            last--;
        }
        return rs;
    }

    public static int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minH = m-1;
        int maxH = 0;
        int minW = n-1;
        int maxW = 0;
        for(int i = 0;i< m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1){
                    minH = Math.min(i,minH);
                    maxH = Math.max(i,maxH);
                    minW = Math.min(j,minW);
                    maxW = Math.max(j,maxW);
                }
            }
        }
        int height = maxH - minH +1;
        int width = maxW -minW +1;
        return height*width;
    }

    public static long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[]dp = new long[n];
        dp[0] = nums[0];
        if(n>1){
            dp[1] = dp[0]+ Math.abs(nums[1]);
        }

        for(int i = 2;i<n;i++){
            if(nums[i]<0){
                if(nums[i-1]<0){
                    dp[i] = Math.max(dp[i-2]+nums[i-1]-nums[i],
                            dp[i-1]+nums[i]);
                }else{
                    dp[i] = dp[i-1]+ Math.abs(nums[i]);
                }
            }else{
                dp[i] = dp[i-1]+ nums[i];
            }
        }
        return dp[n-1];
    }







}
