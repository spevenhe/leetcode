package practice.medium;

import java.util.HashSet;

public class lengthOfLongestSubstring3 {
    public static void main(String[] args) {
        String input = "pwwkew";
        int res = lengthOfLongestSubstring(input);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        char[] sc = s.toCharArray();
        HashSet<Character>set = new HashSet<>();
        int res = 0;
        while(right<n){
            if(!set.contains(sc[right])){
                set.add(sc[right]);
                res = Math.max(res, set.size());
                right++;
            }
            else{
                set.remove(sc[left]);
                left++;
            }
        }
        return res;
    }
}
