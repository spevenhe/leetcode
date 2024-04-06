package practice.list;

import practice.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class pathSum113 {
    List<List<Integer>>res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,new LinkedList<>(),0,targetSum);
        return res;

    }

    public void dfs(TreeNode node, LinkedList<Integer>tmp, int target,int targetSum){
        if(node == null){
            return;
        }
        tmp.add(node.val);
        target+= node.val;
        if(target == targetSum && node.left ==null && node.right == null){
            res.add(new LinkedList<>(tmp));
        }
        if(node.left!=null){
            dfs(node.left, tmp,target,targetSum);
        }
        if(node.right!=null){
            dfs(node.right, tmp,target,targetSum);
        }
        tmp.removeLast();
        target-=node.val;
    }

}
