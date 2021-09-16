public class findKthLargest {

    public static void main(String[] args) {

        int[] a = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(a,k));

    }
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length== 0 || k < 1 || k > nums.length){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //找k最大==找n-k小
        return findUtil(nums,left,right,nums.length - k);

    }

    public static int findUtil(int nums[],int left,int right,int k){
        // 开始忘记了将left right 储存下来，在中间切分的时候，left right会变
        int start = left;
        int end = right;
        if(left>=right){
            return nums[k];
        }
        int rand = left;
        int pivot = nums[rand];
        while (left <= right){
            while(left <= right &&  nums[left]<pivot){
                left++;
            }
            while (left <= right &&  nums[right]>pivot){
                right --;
            }
            if(left<=right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        if((k)>=left){
            return findUtil(nums,left,end,k);

        }if((k)<=right) {
            return findUtil(nums,start,right,k);
        }
        return nums[k];
    }

    public static void swap(int[]nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
