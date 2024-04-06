package practice;

import practice.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TreeCodec449 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
        a.left = b;
//        a.right = c;
//        c.right = d;
        String res = serialize(a);
        TreeNode res2 = deserialize(res);
        System.out.println("s");

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<Integer> store = new LinkedList<>();
        dfs(root,store );
        int n = store.size();
        String res = "";
        int[] sa = store.stream().mapToInt(i->i).toArray();
        for (int i = 0;i<n;i++){
            res = res + sa[i];
            if(i != n-1){
                res = res +",";
            }
        }
        return res;
    }

    public static void dfs(TreeNode node, List<Integer>store){
        if(node == null){
            return;
        }
        store.add(node.val);
        dfs(node.left, store);
        dfs(node.right, store);
    }



    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] buff = data.split(",");
        TreeNode root = de_bfs(buff,0,buff.length-1);
        return root;



    }

    public static TreeNode de_bfs( String[] buff, int start, int end){
        if(start > end){
            return null;
        }
        int rootVal = Integer.parseInt(buff[start]);
        TreeNode root = new TreeNode(rootVal);
        int left = start+1;
        while(left <=end && Integer.parseInt(buff[left])< rootVal){
            left++;
        }
        root.left = de_bfs(buff,start+1,left-1);
        root.right = de_bfs(buff,left,end);
        return root;
    }


}
