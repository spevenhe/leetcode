package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrder {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> tmp = new Stack<>();
        List<Integer>res = new ArrayList<>();
        TreeNode pNode = root;
        while(pNode!=null||!tmp.isEmpty()){
            if(pNode!=null){
                tmp.push(pNode);
                pNode = pNode.left;
            }
            if(pNode == null && !tmp.isEmpty()){
                TreeNode tmpNode = tmp.pop();
                res.add(tmpNode.val);
                pNode = tmpNode.right;
            }
        }
        return res;

    }

}
