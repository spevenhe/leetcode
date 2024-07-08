package test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tree {

    public static class TreeNode{
        public int val;
        public LinkedList<TreeNode> children;
        public int level;

        public TreeNode(int val){
            this.val = val;
            this.children = new LinkedList<>();
            this.level = 0;
        }
    }
    public volatile static int maxSub = 0;
    public volatile static int maxL = 0;

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNextLine()) {
            int m = in.nextInt();
            TreeNode[] nodes = new TreeNode[m+1];
            for(int i = 1; i <= m; i++){
                nodes[i] = new TreeNode(i);
            }
            int n = in.nextInt();
            for(int i = 0; i <n; i++){
                int head = in.nextInt();
                int childNum = in.nextInt();
                for (int j = 0; j < childNum; j++){
                    int child = in.nextInt();
                    nodes[head].children.add(nodes[child]);
                }
            }

            int target = in.nextInt();

            if(target > m){
                System.out.println("[]");
                continue;
            }
            TreeNode targetNode = nodes[target];
            maxSub = 1;
            maxL = 1;
            bfs(targetNode);
            System.out.println("["+maxL+" "+maxSub+"]");

        }
    }

    public static void bfs(TreeNode node){
        LinkedList<TreeNode>list = new LinkedList<TreeNode>();
        list.add(node);
        int level = 1;
        while (!list.isEmpty()){
            int size = list.size();
            if(size>maxSub){
                maxSub = size;
                maxL = level;
            }
            for(int i = 0; i < size; i++){
                TreeNode tmp = list.removeFirst();
                for(TreeNode child : tmp.children){
                    list.addLast(child);
                }
            }
            level +=1;
        }

    }




}
