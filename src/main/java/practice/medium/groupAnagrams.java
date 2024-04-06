package practice.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
    public static void main(String[] args) {
        String a = "eat";
        String b = "ate";
        String encodea = encoded(a);
        String bencode = encoded(b);
        if(encodea.equals(bencode)){
            System.out.println("true");
        }
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res.size());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tmp = new HashMap<>();
        for(String str : strs){
            String encodedStr = encoded(str);
            if(tmp.containsKey(encodedStr)){
                tmp.get(encodedStr).add(str);
            }
            else {
                List<String> tmpV = new LinkedList<>();
                tmpV.add(str);
                tmp.put(encodedStr, tmpV);
            }
        }
        List<List<String>>res = new LinkedList<>();
        for(List<String> value : tmp.values()){
            res.add(value);
        }
        return res;
    }

    public static String encoded(String str){
        char[] encodedStr = new char[26];

        for(char i : str.toCharArray()){
            encodedStr[i-'a']++;
        }
        return new String(encodedStr);
    }


}
