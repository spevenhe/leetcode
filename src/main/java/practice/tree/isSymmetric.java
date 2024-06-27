package practice.tree;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        boolean rs = traverse(root.left,root.right);
        return rs;
    }

    public boolean traverse(TreeNode node1, TreeNode node2){
        if(node1 == null && node2==null){
            return true;
        }
        if(node1 == null || node2 ==null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        boolean rs = traverse(node1.left, node2.right);
        boolean rs2 = traverse(node1.right, node2.left);
        return rs && rs2;
    }
}
