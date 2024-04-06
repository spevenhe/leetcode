package practice.list;

public class deleteDuplicates82 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode rs = deleteDuplicates(a1);


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){

            if(cur.val == next.val){
                while(next!= null && cur.val == next.val){
                    next = next.next;
                }
                if(next == null){
                    prev.next = null;
                    if(cur == head){
                        head = next;
                    }
                    return head;
                }
                if(cur == head){
                    head = next;
                }
                cur = next;
                prev.next = cur;
                next = cur.next;
            }
            else{
                prev = cur;
                cur = next;
                next = cur.next;
            }
        }
        return head;
    }


}
