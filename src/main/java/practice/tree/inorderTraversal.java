package practice.tree;

import java.util.LinkedList;
import java.util.List;

public class inorderTraversal {
    LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    public void traverse(TreeNode root){
        if(root ==null){
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
