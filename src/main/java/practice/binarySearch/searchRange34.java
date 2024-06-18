package practice.binarySearch;

public class searchRange34 {
    public static void main(String[] args) {
//        int[] input = {5,7,7,8,8,10};
        int[] input = {2,2};
        int[] rs = searchRange(input,2);

//        int[] rs2 = searchRange(input,6);
        System.out.println("0");
    }
    public int searchInsert(int[] nums, int target) {
        // 不用判断数组为空，因为题目最后给出的数据范围说数组不为空
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid -1;
            }
        }

        return nums[left]<target?left+1:left;
    }



    public static int[] searchRange(int[] nums, int target) {
        if(nums.length ==0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length-1;
        int leftBound = 0;
        while(left <= right){
            int mid = (left+right+1)/2;
            if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }else {
                leftBound = mid;
                right = mid-1;
            }
        }

        if(nums[leftBound] == target){

            int rightBound = left;
            for(int i = leftBound;i<nums.length;i++){
                if(nums[i]!= target){
                    break;
                }
                rightBound = i;
            }
            return new int[]{leftBound,rightBound};
        }
        return new int[]{-1,-1};



    }


}
