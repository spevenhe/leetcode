package practice.medium;

public class moveZeroes283 {
    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        solutionTwoPointer(input);
    }
    public static void solutionTwoPointer (int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast]==0){
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }

        }
        for(int i = slow;i<nums.length;i++){
            nums[i] = 0;
        }

        System.out.println("a");
    }
}
