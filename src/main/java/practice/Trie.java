package practice;

public class Trie {

    class TreeNode{
        boolean isEnd;
        TreeNode[] childrens = new TreeNode[26];
    }

    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        int n = word.length();
        TreeNode p = root;
        for(int i = 0;i<n;i++){
            char now = word.charAt(i);
            int index = now-'a';
            p.childrens[index] = new TreeNode();
            p = p.childrens[index];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TreeNode p = root;
        for(int i = 0;i<n;i++){
            char now = word.charAt(i);
            int index = now-'a';
            if(p.childrens[index]==null){
                return false;
            }
            p = p.childrens[index];
        }
        if(p.isEnd){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TreeNode p = root;
        for(int i = 0;i<n;i++){
            char now = prefix.charAt(i);
            int index = now-'a';
            if(p.childrens[index]==null){
                return false;
            }
            p = p.childrens[index];
        }

        return true;
    }
}
