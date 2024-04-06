package practice;

public class lcaDeepestLeaves1123 {

    int maxdepth = -1;
    TreeNode rs;

    public static void main(String[] args) {

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findMathDepth(root, 0);
        findNode(root, 0);
        return rs;
    }

    public void findMathDepth(TreeNode root, int depth) {
        if(root == null) {
            maxdepth = Math.max(depth,maxdepth);
            return;
        }
        findMathDepth(root.left, depth+1);
        findMathDepth(root.right, depth+1);
    }

    public int findNode(TreeNode node, int depth){
        if(node ==null){
            return depth;
        }
        int leftDepth = findNode(node.left, depth+1);
        int rightDepth = findNode(node.right, depth+1);
        if(leftDepth == rightDepth && leftDepth == maxdepth){
            rs = node;
        }
        return Math.max(leftDepth, rightDepth);
    }


}
