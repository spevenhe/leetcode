package practice.easy;

import java.util.HashMap;

public class maximumNumberOfStringPairs2744 {

    public static void main(String[] args) {

    }

    public static int maximumNumberOfStringPairs(String[] words) {
        HashMap<String, Integer>map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int ans = 0;
        for(String word : words){
            char[] tmp = new char[2];
            tmp[0] = word.charAt(1);
            tmp[1] = word.charAt(0);
            String find = new String(tmp);
            if(find.equals(word)){
                continue;
            }
            if(map.containsKey(find)){
                int rs = map.get(find);
                ans+=rs;
            }

        }
        return ans/2;

    }
}
