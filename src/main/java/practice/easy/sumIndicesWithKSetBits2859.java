package practice.easy;

import java.util.LinkedList;
import java.util.List;

public class sumIndicesWithKSetBits2859 {

    public static void main(String[] args) {
        List<Integer>nums = new LinkedList<>();
        nums.add(5);
        nums.add(10);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        System.out.println(sumIndicesWithKSetBits(nums,1));
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int j = 0;j<nums.size();j++){
            String binary = Integer.toBinaryString(j);
            int count = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }
            if(count == k){
                res+=nums.get(j);
            }
        }
        return res;
    }
}
