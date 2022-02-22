import java.util.LinkedList;
import java.util.Map;

public class InvertBinaryTree226 {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        a.left = b;
        b.left = c;
        b.right = d;
        a.right = e;
        e.left = f;
        e.right = g;
        TreeNode rs = invertTree(a);
    }

    public static TreeNode invertTree(TreeNode root) {
        TreeNode pNode = root;
        if(root==null){
            return null;
        }
        swapValue(pNode,pNode.left,pNode.right);
        return pNode;

    }
    public static void swapValue(TreeNode pNode, TreeNode left, TreeNode right){
        if(left!=null && right!=null){
            TreeNode tmp = left;
            pNode.left = right;
            pNode.right = tmp;
            swapValue(left,left.left,left.right);
            swapValue(right,right.left,right.right);
        }
        else if(left ==null && right == null){
            return;
        }
        else if(left!=null){
            pNode.right = left;
            pNode.left = null;
            swapValue(left,left.left,left.right);
        }
        else {
            pNode.left = right;
            pNode.right = null;
            swapValue(right,right.left,right.right);
        }
    }
}
