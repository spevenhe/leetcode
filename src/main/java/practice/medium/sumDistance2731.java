package practice.medium;

import java.util.Arrays;

public class sumDistance2731 {

    public static void main(String[] args) {
        int[] input  = {-2,0,2};
        String s = "RLL";
        int d = 3;
        int rs = sumDistance(input,s,d);
        System.out.println(rs);
    }

    public static int sumDistance(int[] nums, String s, int d) {
        char[] dirs = s.toCharArray();
        int length = s.length();
        long[] tmp = new long[length];
        for(int i = 0;i < length;i++){
            if(dirs[i]=='R'){
                tmp[i] = nums[i] + d;
            }else{
                tmp[i] = nums[i] - d;
            }
        }
        Arrays.sort(tmp);
       long res = 0;
        long sum = 0;
        long mod = 1000000000 +7;
        for(int i = 0;i<length;i++){
            res = (res+ tmp[i]*i - sum)%mod;
            sum = (sum+tmp[i])%mod;
        }
        return (int)res;


    }
}
