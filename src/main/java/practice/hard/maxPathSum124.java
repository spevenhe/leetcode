package practice.hard;

import practice.tree.TreeNode;

public class maxPathSum124 {

    public static void main(String[] args) {

    }

    public int res = -1000;
    public int maxPathSum(TreeNode root) {
        maxPathDfs(root);
        return res;

    }

    public int maxPathDfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxPathDfs(root.left);
        int right = maxPathDfs(root.right);

        int maxLeft = Math.max(0,left);
        int maxRight = Math.max(0,right);
        int max = maxLeft+maxRight+root.val;
        res = Math.max(res,max);
        int maxSub = Math.max(maxLeft,maxRight);
        return root.val+maxSub;
    }


}
