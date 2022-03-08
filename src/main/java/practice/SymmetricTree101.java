package practice;

import java.util.Stack;

public class SymmetricTree101 {
    public static void main(String[] args) {

    }
//递归
    public static boolean isSymmetric(TreeNode root) {
        TreeNode pNode = root;
        Boolean rs = true;
        rs = (pNode==null ||  traverse(pNode.left,pNode.right));

        return rs;

    }

    public static boolean traverse(TreeNode left, TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val != right.val){
            return false;
        }
        return traverse(left.left,right.right) && traverse(left.right,right.left);

    }
// stack
    public static boolean isSymmetric2(TreeNode root) {
        TreeNode pNode = root;
        if(pNode==null){
            return true;
        }
        Stack<TreeNode>stack = new Stack<>();
        stack.push(pNode.left);
        stack.push(pNode.right);
        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left==null&& right==null){
                continue;
            }
            if(left==null || right == null || left.val!=right.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);


        }

        return true;

    }
}
