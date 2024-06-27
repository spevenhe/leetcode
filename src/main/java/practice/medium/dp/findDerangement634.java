package practice.medium.dp;

public class findDerangement634 {

    public static void main(String[] args) {
        System.out.println(findDerangement(8));
    }

    public static int findDerangement(int n){
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] =((i-1)*dp[i-2]+(i-1)*dp[i-1])%(int)(1e8+7);
        }
        return dp[n];
    }
}
