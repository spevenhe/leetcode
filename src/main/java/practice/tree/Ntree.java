package practice.tree;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Ntree {

    public static void main(String[] args) {

    }

    int maxDepth = 0;
    public int maxDepth(Node root) {
        traverse(root,1);
        return maxDepth;
    }

    public void traverse(Node node, int depth){
        if(node ==null){
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        for(Node subNode : node.children){
            traverse(subNode,depth+1);
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>rs = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if(root == null){
            return rs;
        }
        queue.add(root);
        while(queue.size()>0){
            List<Integer>tmp = new LinkedList<>();
            int n = queue.size();
            for(int i = 0;i< n;i++){
                Node tmpNode = queue.pollFirst();
                tmp.add(tmpNode.val);
                for(Node node: tmpNode.children){
                    queue.addLast(node);
                }
            }
            rs.add(tmp);

        }
        return rs;
    }
}
