package practice;

public class sortedArrayToBST108 {


    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return findMid(nums,0,n-1);

    }

    public TreeNode findMid(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start+(end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = findMid(nums,start,mid-1);
        node.right = findMid( nums,mid+1,end);
        return node;
    }
}
