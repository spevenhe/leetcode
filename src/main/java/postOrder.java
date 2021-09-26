import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postOrder {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        c.right = d;
        System.out.println(postorderTraversal(a).toString());

    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode>tmp = new Stack<>();
        List<Integer>res = new ArrayList<>();
        TreeNode pNode = root;
        TreeNode visitedRight = root;
        while (pNode!=null || !tmp.isEmpty()){
            if(pNode!=null){
                tmp.push(pNode);
                pNode = pNode.left;
            }
            else {
                TreeNode tmpNode = tmp.peek();
                if(tmpNode.right == null || tmpNode.right == visitedRight ){
                    res.add(tmpNode.val);
                    tmp.pop();
                   visitedRight = tmpNode;
                }else {
                    pNode = tmpNode.right;
                }
            }
        }
        return res;
    }
}
