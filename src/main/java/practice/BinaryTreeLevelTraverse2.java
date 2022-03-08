package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
using size
 */
public class BinaryTreeLevelTraverse2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        TreeNode pNode = root;
        if(pNode == null){
            return res;
        }
        tmpQueue.add(pNode);
        while(!tmpQueue.isEmpty()){
            int levelNum = tmpQueue.size();
            List<Integer>tmpRes = new ArrayList<>();
            for(int i = 0;i<levelNum;i++){
                TreeNode tmpNode = tmpQueue.poll();
                if(tmpNode.left!=null){
                    tmpQueue.add(tmpNode.left);
                }
                if(tmpNode.right!=null){
                    tmpQueue.add(tmpNode.right);
                }
                tmpRes.add(tmpNode.val);
            }
            res.add(0,tmpRes);

        }
        return res;

    }

}
