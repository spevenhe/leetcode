package practice.easy;

public class longestAlternatingSubarray2760 {
    public static void main(String[] args) {
        int[] input = {3,2,5,4};
        int res = longestAlternatingSubarray(input,5);
        System.out.println(res);
    }
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int res = 0;
        int i = 0;
        while(i<n){

            if(nums[i]%2==0){
                int flag = 0;
                l = i;
                r = i;
                while(r<n && nums[r]<=threshold && nums[r]%2==flag){
                    r++;
                    flag = (flag+1)%2;
                }
                res = Math.max(res, r-l);
                i = r==l?i+1:r;
            }else{
                i++;
            }
        }
        return res;

    }
}
