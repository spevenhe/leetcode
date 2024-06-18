package practice.list;

public class reverseKGroup25 {


    public ListNode reverseKGroup(ListNode head, int k) {

        if(k==1){
            return head;
        }
        ListNode cur = head;
        ListNode h = head;
        for(int i = 0;i<k;i++){
            if(cur== null){
                return head;
            }
            cur = cur.next;

        }
        ListNode newHead = reverseList(head, cur);
        h.next = reverseKGroup(cur, k);
        return newHead;


    }

    public ListNode reverseList(ListNode a, ListNode b){
        ListNode prev = null;
        ListNode cur = a;
        ListNode next = a.next;
        while (cur!=b && next!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;

        }
        return prev;
    }
}
