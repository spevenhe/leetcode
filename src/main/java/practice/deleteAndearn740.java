package practice;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class deleteAndearn740 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4,2};
        int res = deleteAndEarn(nums);
        System.out.println(res);
    }

    public static int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+num);
            }
            else {
                map.put(num,num);
            }
        }
        int n = map.keySet().size();
        int[] dp =new int[n+1];
        System.out.println(n);

        int i = 1;
        int lastKey = 10001;
        for(int key : map.keySet()){
            System.out.println(key);
            if(i == 1){
                dp[i++] = map.get(key);
                continue;
            }
//            int value2 = map.get(key+1)==null?0:map.get(key+1);
            if(lastKey == key-1){
                dp[i]=Math.max(dp[i-1],dp[i-2]+map.get(key));
            }else {
                int value1 = map.get(key-1)==null?0:map.get(key-1);
                dp[i]=Math.max(dp[i-1],dp[i-1]+map.get(key)-value1);
            }

            i = i+1;
            lastKey = key;

        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
