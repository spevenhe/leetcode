package practice.medium;

import practice.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class getPermutation60 {

    public static void main(String[] args) {
        String rs = getPermutation(3,3);

    }

    public static String getPermutation(int n, int k) {
        int[] fab = new int[n];
        fab[0] = 1;
        for(int i=1;i<n;i++){
            fab[i] = fab[i-1]*i;
        }

        boolean[] visited = new boolean[n+1];
        StringBuilder permutation = new StringBuilder();
        for(int i = n-1;i>=0;i--){
            int cnt = fab[i];
            for(int j = 1;j<=9;j++){
                if(visited[j]){
                    continue;
                }
                if(cnt <k){
                    k = k- cnt;
                    continue;
                }
                permutation.append(j);
                visited[j] = true;
                break;
            }
        }
        return permutation.toString();

    }

    private List<Integer>rs = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return rs;


    }

    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        traverse(node.right);
        rs.add(node.val);
    }

    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root,low,high);
        return sum;
    }

    private void traverse(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        if(root.val < low || root.val > high){
            return;
        }
        sum += root.val;
        traverse(root.left,low,high);
        traverse(root.right,low,high);
    }




}
