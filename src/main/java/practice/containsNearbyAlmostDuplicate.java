package practice;

import java.util.TreeSet;

public class containsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {2147483646,2147483647};
        TreeSet<Long> ts = new TreeSet<>();
        boolean rs = containsNearbyAlmostDuplicate1(nums,3,3);
        System.out.println(rs);

    }

    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        for(int i = 0;i<n-k;i++){
            for(int j = i+1;j<=i+k;j++){
                long a1 = nums[i];
                long a2 = nums[j];
                long tmp = Math.abs(a1-a2);
                if(tmp<=t){
                    return true;
                }
            }
        }
        return false;
    }
}
