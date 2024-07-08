package practice.medium;

public class nextPermutation31 {

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }


    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1){
            return;
        }
        int swap = 0;
        boolean flag = false;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                swap = i;
                flag = true;
                break;
            }
        }
        int swap2 = n-1;
        for(int i = n-1;i>=swap;i--){
            if(nums[i]>nums[swap]){
                swap2 = i;
                break;
            }
        }

        int left = swap+1;
        int right = n-1;
        if(!flag){
            left = 0;
        }
        else{
            swapFunc(nums,swap,swap2);
        }
        while(left<right){
            swapFunc(nums,left,right);
            left++;
            right--;
        }
    }

    public static void swapFunc(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
