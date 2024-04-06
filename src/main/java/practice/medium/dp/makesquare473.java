package practice.medium.dp;

import java.util.Arrays;
import java.util.Comparator;

public class makesquare473 {

    public static void main(String[] args) {

    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num : matchsticks){
            sum+=num;
        }
        int target = sum/4;
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        int[] sortedmatchsticks = new int[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++) {
            sortedmatchsticks[i] = matchsticks[matchsticks.length - 1 - i];
        }
        int[] buckets = new int[4];
        return backtrack(sortedmatchsticks, 0, buckets, target);
    }

    public boolean backtrack(int[] ms, int index, int[] buckets,int target ){
        if(index == ms.length){
            return true;
        }
        for(int i  =0;i<4;i++){
            if((buckets[i]+ms[index])>target){
                continue;
            }
            buckets[i]+=ms[index];
            boolean rs = backtrack(ms,index+1,buckets, target);
            if(rs == true){
                return true;
            }
            buckets[i] -= ms[index];
        }
        return false;
    }
}
