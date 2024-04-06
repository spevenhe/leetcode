package practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimumTime2809 {

    public static void main(String[] args) {
        ArrayList<Integer>nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(3);
        ArrayList<Integer>nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        int rs = minimumTime(nums1,nums2,4);
        int rs2 = minimumTime2(nums1,nums2,4);
    }

    public static int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] tmp = new int[n][2];
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i< n;i++){
            tmp[i][0] = nums1.get(i);
            tmp[i][1] = nums2.get(i);
            sum1 += nums1.get(i);
            sum2 += nums2.get(i);
        }
        Arrays.sort(tmp,(a,b)->{return  a[1] - b[1];});
        int[]dp = new int[n+1];
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j>0;j--){
                dp[j] = Math.max(dp[j],dp[j-1]+tmp[i][0]+tmp[i][1]*j);
            }
        }
        for(int i = 0;i<=n;i++){
            int sum = sum1+sum2*i - dp[i];
            if(sum <= x){
                return i;
            }
        }
        return -1;
    }

    public static int minimumTime2(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            pairs[i][0] = a;
            pairs[i][1] = b;
            s1 += a;
            s2 += b;
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = pairs[i][0];
            int b = pairs[i][1];
            for (int j = i + 1; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }

        for (int t = 0; t <= n; t++) {
            if (s1 + s2 * t - f[t] <= x) {
                return t;
            }
        }
        return -1;
    }

}
