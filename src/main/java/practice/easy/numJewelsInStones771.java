package practice.easy;

import java.util.HashSet;

public class numJewelsInStones771 {

    public static void main(String[] args) {

    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character>jewelSet = new HashSet<>();
        for(int i = 0; i< jewels.length(); i++){
            jewelSet.add(jewels.charAt(i));
        }
        int res = 0;
        for( int i = 0; i< stones.length();i++){
            if(jewelSet.contains(stones.charAt(i))){
                res+=1;
            }
        }
        return res;
    }
}
