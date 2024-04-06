package practice.medium.dp;

import java.util.Arrays;

public class splitArray410 {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        int res = splitArray(nums,k);
        System.out.println(res);
    }
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= Math.min(i, k); j++) {
//                for (int m = 0; m < i; m++) {
//                    f[i][j] = Math.min(f[i][j], Math.max(f[m][j - 1], sub[i] - sub[m]));
//                }
//            }
//        }

        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int m = 0; m < i; m++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[m][j - 1], sub[i] - sub[m]));
                }
            }
        }

        return f[n][k];



    }
}
