package practice.hard;

import practice.list.ListNode;

public class reverseKGroup25 {

    public static void main(String[] args) {

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        for(int i=0;i<k;i++) {
            if (ptr == null) {
                return head;
            }
            ptr = ptr.next;
        }
            ListNode newHead = reverse(head, ptr);
            newHead.next = reverseKGroup(ptr,k);
            return newHead;
        }


    public ListNode reverse(ListNode head,ListNode ptr) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while(cur!= ptr){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }





}
