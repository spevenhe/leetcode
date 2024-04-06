package practice.medium;

import java.util.HashMap;

public class maximumSum2342 {

    public static void main(String[] args) {

    }

    public int maximumSum(int[] nums) {
        int ans = -1;
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int num : nums) {
            int s = 0; // num 的数位和
            for (int x = num; x > 0; x /= 10) { // 枚举 num 的每个数位
                s += x % 10;
            }
            if (map.containsKey(s)) { // 说明左边也有数位和等于 s 的元素
                int v = map.get(s);
                ans = Math.max(ans, v+num); // 更新答案的最大值
                map.put(s,Math.max(num,v));
            }
            else{
                map.put(s,num);
            }

        }
        return ans;
    }
}
