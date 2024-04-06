package practice.medium;

import java.util.HashMap;

public class subarraySum560 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int res = subarraySum(input,3);
        System.out.println(res);
    }
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int i = 0;i< nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                res+=map.get(sum-k);

            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return res;
    }
}
