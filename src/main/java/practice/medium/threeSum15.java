package practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {

    public static void main(String[] args) {
//        int[] input = {-1,0,1,2,-1,-4};
        int[] input = {0,0,0};
        List<List<Integer>> res = threeSum(input);
        System.out.println("a");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        List<List<Integer>>res = new ArrayList<>();
        if(nums[n]<0){
            return res;
        }
        for(int i = 0; i<n-1; i++){

            if(nums[i]>0 ){
                break;
            }
            int target = -nums[i];
            if(i>0  && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n;
            while(left<right){
                int tmpSum = nums[left]+nums[right];
                if(tmpSum == target){
                    List<Integer>tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    int preLeft = nums[left];
                    while(nums[left]==preLeft && left<right) left++;
                    int preRight = nums[right];
                    while(nums[right]==preRight&& left<right) right--;
                }
                else if(tmpSum < target){
                    int preLeft = nums[left];
                    while(nums[left]==preLeft&& left<right) left++;
                }
                else{
                    int preRight = nums[right];
                    while(nums[right]==preRight&& left<right) right--;
                }

            }

        }
        return res;
    }
}
