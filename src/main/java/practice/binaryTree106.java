package practice;

public class binaryTree106 {

    public static void main(String[] args) {
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        buildTree(inorder,postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    public static TreeNode build(int[] inorder, int instart, int inend,
                                 int[] postorder, int poststart, int postend){
        if(instart > inend || poststart > postend){
            return null;
        }
        int rootVal = postorder[postend];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for(int i = instart;i<=inend;i++){
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }
        int leftsize = index -1 - instart;
        root.left = build(inorder,instart,index-1,
                postorder,poststart,poststart+leftsize);
        root.right = build(inorder,index+1,inend,
                postorder,poststart+leftsize+1,postend-1);
        return root;
    }
}
