package practice.medium.dp;

public class maxProduct152 {

    public int maxProduct(int[] nums) {
        int[] dp_p = new int[nums.length];
        int[] dp_n = new int[nums.length];
        dp_p[0] = nums[0];
        dp_n[0] = nums[0];
        int rs = -11;
        for(int i = 1;i<nums.length;i++){
            dp_p[i] = nums[i];
            dp_n[i] = nums[i];
        }

        for(int i = 1;i<nums.length;i++){
            if(nums[i]>0){
                dp_p[i] = Math.max(dp_p[i-1]*nums[i], nums[i]);
                dp_n[i] = Math.min(dp_n[i-1]*nums[i], nums[i]);
            }else if(nums[i]<0){
                dp_p[i] = Math.max(dp_n[i-1]*nums[i], nums[i]);
                dp_n[i] = Math.min(dp_p[i-1]*nums[i], nums[i]);
            }
            rs = Math.max(rs,dp_p[i]);


        }
        return rs;
    }
}
