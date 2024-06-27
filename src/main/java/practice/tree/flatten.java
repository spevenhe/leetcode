package practice.tree;

public class flatten {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        TreeNode rootTMp = root;
        while (rootTMp!= null){
            if(rootTMp.left == null){
                rootTMp = rootTMp.right;
            }
            else{
                TreeNode leftTreeRightest = rootTMp.left;
                while (leftTreeRightest.right!= null){
                    leftTreeRightest = leftTreeRightest.right;
                }
                leftTreeRightest.right = rootTMp.right;
                rootTMp.right = rootTMp.left;
                rootTMp.left = null;
                rootTMp = rootTMp.right;
            }
        }
    }

}
