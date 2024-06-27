package practice.list;

public class sortList148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        while(left !=null && right!= null){
            if(left.val < right.val){
                ptr.next = left;
                ptr = ptr.next;
                left = left.next;
            }else{
                ptr.next = right;
                ptr = ptr.next;
                right = right.next;
            }
        }
        while (left!=null){
            ptr.next = left;
            ptr = ptr.next;
            left = left.next;
        }
        while (right!=null){
            ptr.next = right;
            ptr = ptr.next;
            right = right.next;
        }
        return newHead.next;
    }

}
