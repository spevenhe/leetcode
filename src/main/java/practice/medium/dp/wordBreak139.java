package practice.medium.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class wordBreak139 {

    public static void main(String[] args) {
        String a = "aaaaaaa";
        List<String> b = new LinkedList<>();
        b.add("aaaa");
        b.add("aaa");
        boolean rs = wordBreak(a, b);
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1;i<= n;i++){
            for(int j = 0;j<i;j++){
                if(set.contains(s.substring(j,i))){
                    if(dp[j]){
                        dp[i] = true;
                    }
                }
            }

        }
        return dp[n];

    }

}
