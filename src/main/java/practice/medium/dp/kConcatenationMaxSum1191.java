package practice.medium.dp;

public class kConcatenationMaxSum1191 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        if(k ==1){
            int[] dp = new int[n];
            dp[0] = arr[0];
            int rs = dp[0] ;
            for(int i = 1;i< n;i++){
                dp[i] = Math.max(dp[i-1]+arr[i],arr[i]) ;
                rs = Math.max(rs,dp[i]);
            }
            return rs<0?0:rs;
        }
        int[] arr2 = new int[2*n];
        for(int i = 0;i<2*n;i++){
            if(i<n){
                arr2[i] = arr[i];
            }else{
                arr2[i] = arr[i-n];
            }
        }
        int[] dp2 = new int[2*n];
        dp2[0] = arr[0];
        int rs2 = dp2[0] ;
        for(int i = 1;i< 2*n;i++){
            dp2[i] = Math.max(dp2[i-1]+arr2[i],arr2[i]);
            rs2 = Math.max(rs2,dp2[i]);
        }


        int sum = 0;
        for(int arri : arr){
            sum=(sum+ arri);
        }


        if(sum < 0){
            return rs2<0?0:rs2;
        }

        else{
            long rsL = ((long)sum*(k-2)+rs2);
            System.out.println(rsL);
            return (int)(rsL%1000000007);
        }
    }
}
