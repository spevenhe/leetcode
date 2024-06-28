package practice.medium.dp;

public class findLength718 {

    public static void main(String[] args) {

    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][m];
        int res = 0;
        for(int i = 0;i<m;i++){
            if(nums1[i]==nums2[0]){
                dp[i][0] = 1;
                res = 1;
            }

        }
        for(int j = 0;j<n;j++){
            if(nums1[0]==nums2[j]){
                dp[0][j] = 1;
                res = 1;
            }

        }


        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j],res);
                }
            }
        }
        return res;
    }
}
