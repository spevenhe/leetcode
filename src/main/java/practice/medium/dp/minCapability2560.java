package practice.medium.dp;

public class minCapability2560 {
    public static void main(String[] args) {
        int[] input = {2,3,5,9};
        int res = minCapability(input,2);
        System.out.println(res);
    }

    public static int minCapability(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int num : nums){
            right = Math.max(num,right);
        }

        while(left+1 <right){
            int res = (left+right)/2;
            int count = check(nums, res);
            if(count < k){
                left = res;
            }else{
                right = res;
            }

        }
        return right;

    }

    public static int check(int[] nums, int max){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= max){
                res+=1;
                i++;
            }
        }
        return res;
    }

}
