package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        a.left = b;
        a.right = c;
        c.left = d;
        System.out.println(levelOrder(a).toString());

    }


    /*
    using flags
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>resTmp = new ArrayList<>();
        TreeNode levelFlag = null;
        Queue<TreeNode>traverseTmp = new LinkedList<>();
        if(root==null){
            return res;
        }
        traverseTmp.add(root);
        traverseTmp.add(null);
        while (!traverseTmp.isEmpty()){

            TreeNode tmpNode = traverseTmp.poll();
            if(tmpNode!=levelFlag){
                resTmp.add(tmpNode.val);
                if(tmpNode.left!=null){
                    traverseTmp.add(tmpNode.left);
                }
                if(tmpNode.right!=null){
                    traverseTmp.add(tmpNode.right);
                }
            }else {
                List<Integer>resTmpHold = resTmp;
                res.add(resTmpHold);
                resTmp = new ArrayList<>();
                if (traverseTmp.isEmpty()){
                    break;
                }
                traverseTmp.add(levelFlag);
            }

        }
        return res;

    }
}
