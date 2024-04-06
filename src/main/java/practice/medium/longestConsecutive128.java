package practice.medium;

import java.util.HashSet;



public class longestConsecutive128 {
    public static void main(String[] args) {
        int[] input = {0,3,7,2,5,8,4,6,0,1,98};
        int res = solution(input);
        System.out.println(res);
    }
    public static int solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for( int num: nums){
            if(set.contains(num+1)){
                continue;
            }
            int curNum = num;
            int length = 1;
            while(set.contains(curNum-1)){
                curNum = curNum-1;
                length = length+1;
            }
            res = Math.max(res,length);
        }
        return res;
    }
}
