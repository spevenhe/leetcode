package practice.medium;

import practice.TreeNode;
import practice.medium.ListNode;

import java.util.List;

public class sortedListToBST109 {

    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode cur = head;
        ListNode curDouble = head;
        ListNode prev = null;
        while(curDouble !=null && curDouble.next!=null){
            prev = cur;
            cur = cur.next;
            curDouble = curDouble.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(cur.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(cur.next);
        root.left = left;
        root.right = right;
        return root;
    }
}
