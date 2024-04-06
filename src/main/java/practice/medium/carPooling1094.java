package practice.medium;

import java.util.Arrays;

public class carPooling1094 {
    public static void main(String[] args) {

    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000];
        Difference df = new Difference(nums);


        int sum =0;

        for(int[] trip : trips){
            int start = trip[1];
            int end = trip[2];
            int val = trip[0];
            df.diff(val,start,end);
        }
        int[] rs = df.result();
        for(int i = 0;i<rs.length;i++){
            if(rs[i]>capacity){
                return false;
            }
        }
        return true;
    }

    class Difference {
        public int[] diff;

        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1;i<nums.length;i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void diff(int val,int start,int end){
            diff[start]+=val;
            if(end < diff.length){
                diff[end]-=val;
            }
        }

        public int[] result(){
            int[] rs = new int[diff.length];
            rs[0] = diff[0];
            for(int i = 1;i<diff.length;i++){
                rs[i] = rs[i-1]+diff[i];
            }
            return rs;
        }
    }


    }
