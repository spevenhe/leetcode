package practice.medium.dp;

import java.util.Arrays;

public class countDigitOne233 {

    public static void main(String[] args) {

    }
    char s[];
    int dp[][];
    public  int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][m];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return dpf(0, 0, true);

    }
    public int dpf(int i, int cnt1, boolean isLimit) {
        if (i == s.length) return cnt1;
        if (!isLimit && dp[i][cnt1] >= 0) return dp[i][cnt1];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0 ; d <= up; ++d) // 枚举要填入的数字 d
            res += dpf(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        if (!isLimit) dp[i][cnt1] = res;
        return res;
    }

}
