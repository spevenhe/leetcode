package practice.list;

public class reverseList206 {


    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        if(cur == null){
            return null;
        }
        ListNode next = cur.next;
        while(next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
