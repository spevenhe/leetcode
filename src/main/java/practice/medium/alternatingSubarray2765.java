package practice.medium;

public class alternatingSubarray2765 {

    public static void main(String[] args) {
//        int[] nums = {2,3,4,3,4};
        int[] nums = {4,3,4};
        System.out.println(alternatingSubarray(nums));
    }

    public static int alternatingSubarray(int[] nums) {
        boolean flag = true;
        int n = nums.length;
        int prev = nums[0];
        int cur = nums[1];
        int res = 0;
        int len = 0;
        for(int i = 1;i<n;i++){
            prev = nums[i-1];
            cur = nums[i];
            int diff = cur - prev;
            if(diff==1){
                if(flag){
                    if(len==0){
                        len = 2;
                    }else{
                        len+=1;
                    }
                    flag = false;
                    res = Math.max(res,len);
                    continue;
                }else{
                    res = Math.max(res,len);
                    len = 2;
                    continue;
                }

            }
            if(!flag && diff==-1){
                len+=1;
                flag = true;
                res = Math.max(res,len);
                continue;
            }
            res = Math.max(res,len);
            len = 0;
        }
        return res;
    }
}
