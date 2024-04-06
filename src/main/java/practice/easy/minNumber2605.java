package practice.easy;

import java.util.HashSet;

public class minNumber2605 {

    public static void main(String[] args) {
        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};
        int rs = minNumber(nums1, nums2);
        System.out.println(rs);
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        HashSet<Integer>set = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        int min = 10;
        for(int num : nums2){
            if(set.contains(num)){
                min = Math.min(min,num);
            }
        }
        if(min<10){
            return min;
        }


        int min1 = findmin(nums1);
        int min2 = findmin(nums2);

        int ten = Math.min(min1,min2);
        int left = Math.max(min1,min2);
        return ten*10+left;
    }

    public static int findmin(int[] input){
        int min = 10;
        for(int i :input){
            min = Math.min(i, min);
        }
        return min;
    }
}
