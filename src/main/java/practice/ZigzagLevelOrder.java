package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        d.left = g;
        f.right = h;
        System.out.println(zigzagLevelOrder(a).toString());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> tmpQueue = new LinkedList<>();
        TreeNode pNode = root;
        if(pNode == null){
            return res;
        }
        tmpQueue.add(pNode);
        int level = 0;
        while(!tmpQueue.isEmpty()){
            int levelNum = tmpQueue.size();
            List<Integer>tmpRes = new ArrayList<>();
            TreeNode tmpNode = root;
            for(int i = 0;i<levelNum;i++){

                if(level%2==0){
                    tmpNode = tmpQueue.get(levelNum-1-i);
                    if(tmpNode.right!=null){
                        tmpQueue.add(tmpNode.right);
                    }
                    if(tmpNode.left!=null){
                        tmpQueue.add(tmpNode.left);
                    }

                }
                else {
                    tmpNode = tmpQueue.get(levelNum-1-i);
                    if(tmpNode.left!=null){
                        tmpQueue.add(tmpNode.left);
                    }
                    if(tmpNode.right!=null){
                        tmpQueue.add(tmpNode.right);
                    }
                }
            }
            for (int i = 0; i<levelNum;i++){
                tmpRes.add(tmpQueue.removeFirst().val);
            }
            res.add(tmpRes);
            level++;
        }
        return res;
    }

}
