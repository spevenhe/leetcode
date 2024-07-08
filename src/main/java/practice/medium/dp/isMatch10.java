package practice.medium.dp;

public class isMatch10 {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = isMatch(s,p);
        System.out.println(res);
    }

    public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int m = sArr.length;
        int n = pArr.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= n; i+= 2) {
            if (pArr[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1;j<=n;j++){
                if(pArr[j-1]!='*'){
                    if(sArr[i-1] != pArr[j-1] && pArr[j-1] != '.'){
                        dp[i][j] = false;
                    }else{
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else { // pArr[j-1] == '*'
                    if(pArr[j-2]== sArr[i-1] || pArr[j-2] == '.'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];




    }


}
