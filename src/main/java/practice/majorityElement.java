package practice;

public class majorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == res){
                count++;
            }else {
                count --;
                if(count == 0){
                    res = nums[i];
                    count = 1;
                }
            }
        }
        System.out.println(res);
    }


}
