package practice.medium;

import java.util.HashMap;

public class tupleSameProduct1726 {

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i< n;i++){
            for(int j = i+1;j<n;j++){
                int tmp = nums[i]*nums[j];
                map.put(tmp,map.getOrDefault(tmp,0)+1 );
            }
        }
        int res = 0;
        for(int value : map.values()){
            res+= (value-1)*value/2;
        }
        return res*8;
    }
}
