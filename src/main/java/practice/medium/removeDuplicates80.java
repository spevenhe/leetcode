package practice.medium;

public class removeDuplicates80 {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int num : nums){
            if(index >=2 && nums[index-2] == num){
                continue;
            }
            else {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }
}
