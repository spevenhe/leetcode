package practice.hard;

import java.util.HashMap;

public class minWindow76 {

    public static void main(String[] args) {

    }

    public String solution(String s, String t) {
        HashMap<Character,Integer> source = new HashMap<>();
        HashMap<Character,Integer> target = new HashMap<>();
        char[] sourceChars = s.toCharArray();
        for(char c : t.toCharArray()){
            target.put(c,target.getOrDefault(c,0)+1);
        }
        int targetKey = target.keySet().size();
        int fast = 0;
        int slow = 0;
        int valid = 0;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        while(fast < sourceChars.length){
            source.put(sourceChars[fast],source.getOrDefault(sourceChars[fast],0)+1);
            if(target.containsKey(sourceChars[fast])){
                if(target.get(sourceChars[fast]).equals(source.get(sourceChars[fast]))){
                    valid++;
                }
                while(valid == targetKey){
                    if(minLength > fast-slow+1){
                        minLength = fast-slow+1;
                        res = s.substring(slow,fast+1);
                    }
                    char slowChar = sourceChars[slow];
                    source.put(slowChar,source.get(slowChar)-1);
                    if(target.containsKey(slowChar)){
                        if(target.get(slowChar) > source.get(slowChar)){
                            valid--;
                        }
                    }
                    slow++;

                }
            }
            fast++;
        }
        return res;
    }
}
