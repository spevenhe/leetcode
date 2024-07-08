package practice;

import java.util.ArrayList;
import java.util.List;

public class deconder98 {
    public static void main(String[] args) {
        String s = "12";
        int a1 = 10;
        long a = Long.valueOf(a1);
        int rs = numDecodings(s);
        System.out.println(rs);
    }
    public int reverse(int x) {
        Long res = 0L;

        while(x!=0){
            int tmp = x%10;
            x = x/10;
            res = res*10+tmp;
        }
        if(res> Integer.MAX_VALUE || res< Integer.MIN_VALUE){
            return 0;
        }
        ArrayList<int[]> ans  =  new ArrayList<>();

        int result = Math.toIntExact(res);
        return result;


    }

    public static int numDecodings(String s) {
        if(s==null){
            return 0;
        }
        int n = s.length();
        if(n==0 || Character.getNumericValue(s.charAt(0))==0){
            return 0;
        }
        int[]dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1;i<n;i++){

            int pre = Character.getNumericValue(s.charAt(i-1));
            int now = Character.getNumericValue(s.charAt(i));
            if(now == 0){
                if(pre>2 || pre == 0){
                    return 0;
                }
                else{
                    dp[i] = dp[i-1]+1;
                }
            }
            if( pre<=2 && now <=6){
                dp[i] = dp[i-1]+2;
            }
            else{
                dp[i] = dp[i-1]+1;
            }
        }
        return dp[n-1];
    }
}
