package practice.medium;

public class singleNumber260 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,2,5};
        int[] res = singleNumber(nums);
        for(int ri:res){
            System.out.println(ri);
        }
    }

    public static int[] singleNumber(int[] nums) {
        int tmp = 0;
        for(int num : nums){
            tmp ^= num;
        }
        int k = 0;
        for(int i = 0;i<31;i++){
            if(((tmp>>i)&1) == 1){
                k = i;
                break;
            }
        }
        int[] ans = new int[2];
        for(int num : nums){
            if((num>>k & 1)==1){
                ans[0] ^= num;
            }
            else{
                ans[1] ^= num;
            }
        }
        return ans;
    }


}
