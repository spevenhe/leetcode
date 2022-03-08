package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrder {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        System.out.println(preorderTraversal(a).toString());
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        TreeNode first = root;
        List<Integer>res = new ArrayList<>();
        Stack<TreeNode>tmp = new Stack<>();

        while(first != null || !tmp.isEmpty()){
            if(first!=null){
                res.add(first.val);
                tmp.push(first);
                first = first.left;
            }
            if(first==null&&!tmp.isEmpty()){
                first = tmp.pop();
                first = first.right;
            }
        }
        return res;
    }
}
