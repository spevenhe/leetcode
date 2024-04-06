package practice.easy;

import java.util.HashMap;

public class twoSum1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];
        for(int i = 0;i< n; i++){
            int left = target - nums[i];
            if(map.containsKey(left)){
                res[0] = i;
                res[1] = map.get(left);
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;

    }
}
